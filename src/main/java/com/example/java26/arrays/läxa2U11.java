package com.example.java26.arrays;

public class läxa2U11 {
    public record Bok(String titel, String författare, int år) {
}

    public static class BokInfo {

        public static String beskrivning(Bok b) {
            return "Titel: " + b.titel() + " – Författare: " + b.författare() + " – Utgiven: " + b.år();
        }

        public static void main(String[] args) {
            Bok bok = new Bok("The Silmarillion", "J. R. R. Tolkien", 1977);
            IO.println(beskrivning(bok));



        }
    }
}

