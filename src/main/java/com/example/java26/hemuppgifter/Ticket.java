package com.example.java26.hemuppgifter;

public class Ticket {
    String eventName;

    // default constructor
    public Ticket() {
        this.eventName = "Evenemang";
    }

    public Ticket(String eventName) {
        this.eventName = eventName;

        Ticket t1 = new Ticket();               //eventName = "Evenemang"
        Ticket t2 = new Ticket("Konsert 2026 - 09 - 15"); // eventName = Specifikt"
    }
}
