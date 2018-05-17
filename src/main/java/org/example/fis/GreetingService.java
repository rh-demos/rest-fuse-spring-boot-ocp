package org.example.fis;

import org.apache.camel.Exchange;

public class GreetingService {
    private String standardGreeting;
    public void setStandardGreeting(String newStandardGreeting) {
        standardGreeting = newStandardGreeting;
    }
    public String getStandardGreeting() {
        return standardGreeting;
    }
    public Greeting getGreeting(Exchange exchange) {
        return new Greeting(standardGreeting + exchange.getIn().getHeader("name", "stranger", String.class));
    }
}
