import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Guest {

    public void getBooksList(){

    }
    public void borrowBook(){
        System.out.println("you will be directed to menu");
        Main.menu();
    }
    public void Control(ArrayList<Book> books){
        System.out.println("you are in guest mode");
        System.out.println("choose only number!");
        System.out.println("1 : get list of books");
        System.out.println("2 : borrow book");
        System.out.println("3 : Back to main menu");
        Scanner input = new Scanner(System.in);
        try{
            int choice = input.nextInt();
            if(choice == 1){
                for(Book book : books){
                    book.displayBook();
                    System.out.println("\n");

                }
                Control(books);
            }else if(choice == 2){
                borrowBook();
            }else if(choice == 3){
                Main.menu();
            }
        }catch(InputMismatchException e){
            System.out.println("invalid input");
            Control(books);
        }


    }
}
