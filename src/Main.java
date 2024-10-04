
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Person> persons = new ArrayList<>();
    private static ArrayList<Librarian> librarians = new ArrayList<>();
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();
    private static Library library;
    private static Guest person4 = new Guest();







    public static void main(String[] args) {
        System.out.println("Welcome to NewUU library ");
        initializeData();
        menu();
    }
    private static void initializeData() {
        // Local variables for initial book and person creation
        BookIDGenerator bookIDGenerator = new BookIDGenerator();
        String bookId1 = bookIDGenerator.generateBookID();
        String bookId2 = bookIDGenerator.generateBookID();
        System.out.println(bookId1+" "+bookId2);
        // Create books and add to the list
        books.add(new Book("Atomic Habits", "James Clear", bookId1, true));
        books.add(new Book("48 Laws of Power", "Robert Greene", bookId2, true));

        // Create persons
        Admin person1 = new Admin("Nodirbek1", 19, "1", "nodirbek1", "1", Role.Admin,library);
        Librarian person2 = new Librarian("Nodirbek2", 19, "2", "nodirbek2", "2", Role.Librarian, books,library);
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        Member person3 = new Member("Nodirbek3", 19, "3", "nodirbek3", "3", Role.Member, borrowedBooks,library);


        // Add persons to their respective lists
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        librarians.add(person2);
        admins.add(person1);
        members.add(person3);

        // Initialize library
        library = new Library("Horizon", "Tashkent Mustaqillik k", books, members, librarians, admins, persons);
    }
    public static void menu() {








        System.out.println("\tChoose with numbers only!!!");
        System.out.println("\t1. Login as ADMIN");
        System.out.println("\t2. Login as Librarian");
        System.out.println("\t3. Login as Member");
        System.out.println("\t4. Continue as Guest");
        System.out.println("\t0. Exit \n");
        System.out.println("number of books :"+books.size());
        Scanner input = new Scanner(System.in);
        System.out.println("your choice: ");
        try{
            int choice = input.nextInt();
            while (choice < 0 || choice > 4) {
                System.out.println("you entered wrong choice");

                System.out.println("your choice: ");
                choice = input.nextInt();

            }
            if (choice == 1) {
                System.out.println("enter you login as admin:");
                String login = input.next();
                String password = input.next();
                for (Admin admin : admins) {
                    if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                        admin.Control();
                    }else{
                        System.out.println("wrong password or login");
                        menu();
                    }
                }

            }else if(choice == 2){
                System.out.println("enter you login as librarian:");
                String login = input.next();
                String password = input.next();
                for (Librarian librarian : librarians) {
                    if (librarian.getLogin().equals(login) && librarian.getPassword().equals(password)) {
                        librarian.Control(members);
                    }else{
                        System.out.println("wrong password or login");
                        menu();
                    }
                }
            }else if(choice == 3){
                System.out.println("enter you login as member:");
                String login = input.next();
                String password = input.next();
                for (Member member : members) {
                    if (member.getLogin().equals(login) && member.getPassword().equals(password)) {
                        member.Control();
                    }else{
                        System.out.println("wrong password or login");
                        menu();
                    }
                }
            }else if(choice == 4){
                person4.Control(books);



            }else{
                return;
            }
        }catch (Exception e){
            System.out.println("your choice is incorrect");
            menu();

        }




    }



}
