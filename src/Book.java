import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String bookID;
    private boolean isAvailable;

    public Book(String title, String author, String bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        this.isAvailable = isAvailable;

    }
    public void borrowBook(){
        if (isAvailable){
            System.out.println("book is borrowed");
            isAvailable = false;
            displayBook();


        }else{
            System.out.println("book is not available, already borrowed");
            isAvailable = false;
        }
    }
    public void returnBook() {
        if (isAvailable){
            System.out.println("book was not borrowed where did you get this book?");

        }else{
            System.out.println("book is returned");
            isAvailable = true;
        }
    }
    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Book ID: " + bookID);
        System.out.println("Available: " + isAvailable);

    }

    public String getBookID() {
        return bookID;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
}
