package org.example.fis;

public class Greeting {
    private String greeting;
    public Greeting(String name) {
        greeting = "Hello " + name;
    }
    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String newGreeting) {
        greeting = newGreeting;
    }
}
