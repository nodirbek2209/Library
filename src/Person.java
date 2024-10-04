

public class Person {
    private String name;
    private int age;
    private String ID;
    private String login;
    private String password;
    private Role role;
    public Person(String name, int age, String ID, String login, String password, Role role) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.role=role;

    }
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + ID);

    }
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
