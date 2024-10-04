import java.util.ArrayList;
public class Library {
    private String name;
    private String location;
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Librarian> librarians;
    private ArrayList<Admin> admins;
    private ArrayList<Person> persons;
    public Library( String name, String location, ArrayList<Book> books,ArrayList<Member> members,ArrayList<Librarian> librarians,ArrayList<Admin> admins,ArrayList<Person> persons) {
        this.name = name;
        this.location = location;
        this.books = books;
        this.members = new ArrayList<Member>();
        this.librarians = librarians;
        this.admins = admins;
        this.persons = persons;


    }
    public void displayall() {
        for(Person person:persons){
            person.display();
        }
    }
    public void displayBooks(){
        for(Book book:books){
            book.displayBook();
            System.out.println("\n");
        }
        System.out.println("all books: ");
    }
    public ArrayList<Member> getMembers(){
        return members;
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
    public ArrayList<Librarian> getLibrarians(){
        return librarians;
    }
    public ArrayList<Admin> getAdmins(){
        return admins;
    }
    public ArrayList<Person> getPersons(){
        return persons;
    }


}
