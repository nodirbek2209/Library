import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Member extends Person {
    private ArrayList<Book> borrowedBooks;
    private Library library;
    public Member(String name, int age, String ID, String login, String password, Role role, ArrayList<Book> borrowedBooks,Library library) {
        super(name, age, ID, login, password, role);
        this.borrowedBooks=borrowedBooks;
        this.library=library;
    }
    public void borrowBook() {
        Scanner input=new Scanner(System.in);
        System.out.println("enter bookID");
        String bookID=input.nextLine();
        for(Book book:library.getBooks()){
            if (book.getBookID().equals(bookID)) {
                book.borrowBook();
                borrowedBooks.add(book);
                Control();
            }

        }
        System.out.println("book with id doesn't exist ");
        Control();



    }

    public void returnBook() {
        Scanner input=new Scanner(System.in);
        System.out.println("enter bookID");
        String bookID=input.nextLine();
        for(Book book:borrowedBooks){
            if (book.getBookID().equals(bookID)) {
                book.displayBook();
                book.returnBook();
                borrowedBooks.remove(book);

                Control();
            }
        }
        System.out.println("book with id doesn't exist in the borrowed list ");

    }

    public void setBorrowedBooks(Book book) {
        borrowedBooks.add(book);

    }
    public void Control() {
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
                borrowBook();
            }else if(choice==2){
                returnBook();

            }else if(choice==3){
                for(Book book:getBorrowedBooks()){
                    book.displayBook();
                    System.out.println("\n");

                }

                System.out.println("Borrowed books number:"+borrowedBooks.size());
                Control();
            }else if(choice==4){
                Main.menu();
            }


        }catch(InputMismatchException e){
            System.out.println("Please enter a valid number");
            Control();
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
