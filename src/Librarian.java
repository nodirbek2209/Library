import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends Person {
    private ArrayList<Book> managedBooks;
    private Library library;
    public Librarian(String name, int age, String ID, String login, String password, Role role, ArrayList<Book> managedBooks,Library library) {
        super(name, age, ID, login, password, role);
        this.managedBooks = managedBooks;
        this.library=library;


    }

    public void setManagedBook(Book book) {

        managedBooks.add(book);
        System.out.println("added book succesfully to the list");

    }
    public ArrayList<Book> getManagedBooks() {
        return managedBooks;
    }


    public void addBook(ArrayList<Book> books, ArrayList<Member> members) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter title of the book:");

        String title = input.nextLine();
        System.out.println("enter author of the book:");
        String author = input.nextLine();
        BookIDGenerator generator = new BookIDGenerator();
        String bookID = generator.generateBookID();

        Book addingbook=new Book(title,author,bookID,true);
        books.add(addingbook);
        addingbook.displayBook();

        System.out.println("book added");
        Control(members);
    }
    public void removeBook(ArrayList<Book> books,ArrayList<Member> members) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter ID of the book:");
        String bookID = input.nextLine();
        for(Book book:books) {
            if (book.getBookID().equals(bookID)) {
                books.remove(book);
                System.out.println("book removed successfully");
                Control(members);
            }
        }
        System.out.println("book is not found");
        Control(members);



    }
    public void issueBook(ArrayList<Book> managedBooks, ArrayList<Member> members) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter ID of the book:");

        String bookID = input.nextLine();
        System.out.println("enter id of member");
        String memberID = input.nextLine();
        for(Book book:managedBooks) {
            if (book.getBookID().equals(bookID)) {
                book.borrowBook();
                book.displayBook();
                for(Member member:members) {
                    if(member.getID().equals(memberID)) {
                        member.setBorrowedBooks(book);

                        System.out.println("book added successfully to borrowed books");
                        Control(members);

                    }
                }


            }
        }



    }
    public void returnBook(ArrayList<Book> books,ArrayList<Member> members) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter ID of the book:");
        String bookID = input.nextLine();
        for(Member member:members) {
            if (member.findBookByID(bookID)!=null){
                member.removeBook(member.findBookByID(bookID));
                member.findBookByID(bookID).returnBook();
                Control(members);
            }

            }
        }

    public void Control(ArrayList<Member> members) {
        System.out.println("you are log in as librarian");
        Scanner input = new Scanner(System.in);
        System.out.println("choose only numbers!");
        System.out.println("1 : add book");
        System.out.println("2 : remove book");
        System.out.println("3 : issue book");
        System.out.println("4 : return book");

        System.out.println("5 : exit to main menu");
        try{
            int choice = input.nextInt();
            if(choice == 1) {
                addBook(managedBooks,members);
            }else if(choice == 2) {
                removeBook(managedBooks,members);
            }else if(choice == 3) {
                issueBook(managedBooks,members);
            }else if(choice == 4) {
                returnBook(managedBooks,members);
            }else if(choice == 5) {
                Main.menu();
            }

        }catch (Exception e){
            Control(members);

        }
    }

}





