import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Member extends Person {
    private ArrayList<Book> borrowedBooks;
    public Member(String name, int age, String ID, String login, String password, Role role, ArrayList<Book> borrowedBooks) {
        super(name, age, ID, login, password, role);
        this.borrowedBooks=borrowedBooks;
    }
    public void borrowBook(ArrayList<Book> books) {
        Scanner input=new Scanner(System.in);
        System.out.println("enter bookID");
        String bookID=input.nextLine();
        for(Book book:books){
            if (book.getBookID().equals(bookID)) {
                book.borrowBook();
                borrowedBooks.add(book);
                Control(books);
            }

        }
        System.out.println("book with id doesn't exist ");
        Control(books);



    }

    public void returnBook(ArrayList<Book> books) {
        Scanner input=new Scanner(System.in);
        System.out.println("enter bookID");
        String bookID=input.nextLine();
        for(Book book:borrowedBooks){
            if (book.getBookID().equals(bookID)) {
                book.displayBook();
                book.returnBook();
                borrowedBooks.remove(book);

                Control(books);
            }
        }
        System.out.println("book with id doesn't exist in the borrowed list ");

    }

    public void setBorrowedBooks(Book book) {
        borrowedBooks.add(book);

    }
    public void Control(ArrayList<Book> books) {
        System.out.println("you are logged in as member");
        System.out.println("choose only numbers!");
        System.out.println("1 Borrow Book");
        System.out.println("2 Return Book");
        System.out.println("3 List of borrowed books");
        System.out.println("4 Exit to menu");
        Scanner input=new Scanner(System.in);
        try{
            int choice=input.nextInt();
            if(choice==1){
                borrowBook(books);
            }else if(choice==2){
                returnBook(books);

            }else if(choice==3){
                for(Book book:getBorrowedBooks()){
                    book.displayBook();
                    System.out.println("\n");

                }

                System.out.println("Borrowed books number:"+borrowedBooks.size());
                Control(books);
            }else if(choice==4){
                Main.menu();
            }


        }catch(InputMismatchException e){
            System.out.println("Please enter a valid number");
            Control(books);
                }

        }



    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public Book findBookByID(String bookID) {
        for (Book book : borrowedBooks) {
            if(book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }
    public void removeBook(Book book) {
        borrowedBooks.remove(book);
    }
}
