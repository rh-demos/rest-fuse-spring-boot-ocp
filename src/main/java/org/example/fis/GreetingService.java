package org.example.fis;

import org.apache.camel.Exchange;
import java.util.List;
import java.util.Map;

public class GreetingService {
    private String standardGreeting;
    public void setStandardGreeting(String newStandardGreeting) {
        standardGreeting = newStandardGreeting;
    }
    public String getStandardGreeting() {
        return standardGreeting;
    }
    public Greeting getGreeting(Exchange exchange) {
        List<Map<String, Object>> rows = exchange.getIn().getBody(List.class);
        System.out.println("Processing " + exchange.getIn().getBody());
        String name = "Stranger";
        if(rows.size() > 0) {
            name = (String) rows.get(0).get("FIRST_NAME");
        }        
        //return new Greeting(standardGreeting + exchange.getIn().getHeader("name", "stranger", String.class));
        return new Greeting(standardGreeting + name);
    }
}
