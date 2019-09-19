package spring.core.app;

public class Client {
    private int id;
    private String fullName;
    private String greeting;

    public Client() {
    }

    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGreeting() {
        return greeting;
    }
}
