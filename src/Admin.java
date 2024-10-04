import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Person {


    public Admin(String name, int age, String ID, String login, String password, Role role) {
        super(name, age, ID, login, password, role);
    }
    public void addMember(Library library) {
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
        Member newmember= new Member(name,age,ID,login,password,Role.Member,borrowedBooks);
        library.getMembers().add(newmember);
        System.out.println("new member added");
        Control(library);


    }
    public void removeMember(Library library) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter id of member:");
        String ID=in.nextLine();
        for(Member member : library.getMembers()) {
            if(member.getID().equals(ID)) {
                library.getMembers().remove(member);
                System.out.println("removed member");
                Control(library);
            }
        }
        System.out.println("member not found");
        Control(library);
    }
    public void viewMembers(Library library) {
        for(Member member : library.getMembers()) {
            member.display();
            System.out.println("\n");
        }
        Control(library);

    }
    public void addLibrarian(Library library) {
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


        Librarian newlibrarian=new Librarian(name,age,ID,login,password,Role.Librarian,library.getBooks());
        library.getLibrarians().add(newlibrarian);
        System.out.println("new librarian added");
        Control(library);

    }
    public void removeLibrarian(Library library) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter id of librarian:");
        String ID=in.nextLine();
        for(Librarian librarian : library.getLibrarians()) {
            if(librarian.getID().equals(ID)) {
                library.getLibrarians().remove(librarian);
                System.out.println("removed member");
                Control(library);
            }
        }
        System.out.println("librarian not found");
        Control(library);
    }
    public void viewLibrarians(Library library) {
        for(Librarian librarian : library.getLibrarians()) {
            librarian.display();
            System.out.println("\n");
        }
        Control(library);
    }
    public void addAdministrator(Library library) {
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
        Admin newadmin= new Admin(name,age,ID,login,password,Role.Admin);
        library.getAdmins().add(newadmin);
        System.out.println("new admin added");
        Control(library);
    }

    public void Control(Library library){
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
                addMember(library);
            }else if (choice == 2){
                removeMember(library);
            }else if (choice == 3){
                viewMembers(library);
            }else if (choice == 4){
                addLibrarian(library);
            }else if (choice == 5){
                removeLibrarian(library);
            }else if (choice == 6){
                viewLibrarians(library);

            }else if(choice == 7){
                addAdministrator(library);
            }



        }catch(InputMismatchException e){
            System.out.println("wrong input");
            Control(library);

        }
    }


}
