import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Person {

    private Library library;
    public Admin(String name, int age, String ID, String login, String password, Role role,Library library) {
        super(name, age, ID, login, password, role);
        this.library=library;
    }
    public void addMember() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter name of member:");
        String name=in.nextLine();
        System.out.println("enter age of member:");
        int age=in.nextInt();
        System.out.println("enter id of member:");
        String ID=in.nextLine();
        System.out.println("enter login of member:");
        String login=in.nextLine();
        System.out.println("enter password of member:");
        String password=in.nextLine();

        ArrayList<Book> borrowedBooks = new ArrayList<>();
        Member newmember= new Member(name,age,ID,login,password,Role.Member,borrowedBooks,library);
        library.getMembers().add(newmember);
        System.out.println("new member added");
        Control();


    }
    public void removeMember() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter id of member:");
        String ID=in.nextLine();
        for(Member member : library.getMembers()) {
            if(member.getID().equals(ID)) {
                library.getMembers().remove(member);
                System.out.println("removed member");
                Control();
            }
        }
        System.out.println("member not found");
        Control();
    }
    public void viewMembers() {
        for(Member member : library.getMembers()) {
            member.display();
            System.out.println("\n");
        }
        Control();

    }
    public void addLibrarian() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter name of librarian:");
        String name=in.nextLine();
        System.out.println("enter age of librarian:");
        int age=in.nextInt();
        System.out.println("enter id of librarian:");
        String ID=in.nextLine();
        System.out.println("enter login of librarian:");
        String login=in.nextLine();
        System.out.println("enter password of librarian:");
        String password=in.nextLine();


        Librarian newlibrarian=new Librarian(name,age,ID,login,password,Role.Librarian,library.getBooks(),library);
        library.getLibrarians().add(newlibrarian);
        System.out.println("new librarian added");
        Control();

    }
    public void removeLibrarian() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter id of librarian:");
        String ID=in.nextLine();
        for(Librarian librarian : library.getLibrarians()) {
            if(librarian.getID().equals(ID)) {
                library.getLibrarians().remove(librarian);
                System.out.println("removed member");
                Control();
            }
        }
        System.out.println("librarian not found");
        Control();
    }
    public void viewLibrarians() {
        for(Librarian librarian : library.getLibrarians()) {
            librarian.display();
            System.out.println("\n");
        }
        Control();
    }
    public void addAdministrator() {
        Scanner in = new Scanner(System.in);
        System.out.println("enter name of administrator:");
        String name=in.nextLine();
        System.out.println("enter age of administrator:");
        int age=in.nextInt();
        System.out.println("enter id of administrator:");
        String ID=in.nextLine();
        System.out.println("enter login of administrator:");
        String login=in.nextLine();
        System.out.println("enter password of administrator:");
        String password=in.nextLine();
        Admin newadmin= new Admin(name,age,ID,login,password,Role.Admin,library);
        library.getAdmins().add(newadmin);
        System.out.println("new admin added");
        Control();
    }

    public void Control(){
        System.out.println("you are logged in as admin");
        System.out.println("choose only numbers!");
        System.out.println("1 : add member");
        System.out.println("2 : delete member");
        System.out.println("3 : view members");
        System.out.println("4 : add librarian");
        System.out.println("5 : delete librarian");
        System.out.println("6 : view librarian");
        System.out.println("7 : add administrator");
        System.out.println("8 : delete administrator");
        System.out.println("9 : view administrator");
        System.out.println("your choice: ");
        Scanner input = new Scanner(System.in);
        try{
            int choice = input.nextInt();
            if (choice == 1){
                addMember();
            }else if (choice == 2){
                removeMember();
            }else if (choice == 3){
                viewMembers();
            }else if (choice == 4){
                addLibrarian();
            }else if (choice == 5){
                removeLibrarian();
            }else if (choice == 6){
                viewLibrarians();

            }else if(choice == 7){
                addAdministrator();
            }



        }catch(InputMismatchException e){
            System.out.println("wrong input");
            Control();

        }
    }


}
