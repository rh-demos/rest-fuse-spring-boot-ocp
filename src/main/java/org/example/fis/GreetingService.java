package org.example.fis;

public class GreetingService {
    private String name;
    public void setName(String newName) {
        name = newName;
    }
    public String getName() {
        return name;
    }
    public Greeting getGreeting() {
        return new Greeting(name);
    }
}
