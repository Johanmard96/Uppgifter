package com.example.java26.bibblan;

import java.util.Scanner;

/*
CLI för bibliotekshanteraren.
Loopar tills användaren avslutar.
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bibliotek bibliotek = new Bibliotek();

    public static void main(String[] args) {
        seedData();

        boolean running = true;
        while (running) {
            printMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> addBokFlow();
                case "2" -> nyMedlemFlow();
                case "3" -> lånaBokFlow();
                case "4" -> lämnaBokFlow();
                case "5" -> sökFlow();
                case "6" -> bibliotek.visaBöckerEfterTitel();
                case "7" -> statistikFlow();
                case "e", "E" -> {
                    IO.println("Avslutar. Hej då!");
                    running = false;
                }
                default -> IO.println("Ogiltigt val - försök igen");
            }
            IO.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        IO.println("The bibble");
        IO.println("====================");
        IO.println("1. Lägg till bok");
        IO.println("2. Registrera medlem");
        IO.println("3. Låna bok");
        IO.println("4. Återlämna bok");
        IO.println("5. Sök bok (titel eller författare)");
        IO.println("6. Visa alla böcker och status");
        IO.println("7. Visa medlem med flest aktiva lån");
        IO.println("e. Avsluta");
        IO.print("Val: ");
    }

    private static void addBokFlow() {
        IO.print("ISBN: ");
        String isbn = scanner.nextLine().trim();
        IO.print("Titel: ");
        String titel = scanner.nextLine().trim();
        IO.print("Författare: ");
        String författare = scanner.nextLine().trim();

        if (isbn.isEmpty() || titel.isEmpty() || författare.isEmpty()) {
            IO.println("Var god fyll i alla fält");
            return;
        }
        boolean added = bibliotek.nyBok(new Bok(isbn, titel, författare));
        IO.println(added ? "Boken tillagd." : "En bok med samma ISBN finns redan.");
    }

    private static void nyMedlemFlow() {
        IO.print("Namn: ");
        String namn = scanner.nextLine().trim();
        if (namn.isEmpty()) {
            IO.println("Namn får inte vara tomt");
            return;
        }
        Medlem medlem = bibliotek.registreraMedlem(namn);
        IO.println("Medlem registrerad: " + medlem);
    }

    private static void lånaBokFlow() {
        IO.print("ISBN på boken: ");
        String isbn = scanner.nextLine().trim();

        Integer medlemId = readInt("Medlems-id: ");
        if (medlemId == null) {
            return;
        }
        IO.println(bibliotek.lånadBok(isbn, medlemId));
    }

    private static void lämnaBokFlow() {
        IO.print("ISBN på boken: ");
        String isbn = scanner.nextLine().trim();
        IO.println(bibliotek.återlämnaBok(isbn));
    }

    private static void sökFlow() {
        IO.print("Sökterm (titel eller författare): ");
        String query = scanner.nextLine().trim();
        Bok[] hits = bibliotek.search(query);

        if (hits.length == 0) {
            IO.println("Inga träffar.");
            return;
        }
        IO.println("Hittade " + hits.length + " bok/böcker:");
        for (Bok b : hits) {
            IO.println(" " + b.titel() + " - " + b.författare());
        }
    }

    private static void statistikFlow() {
        Medlem top = bibliotek.flestLån();
        if (top == null) {
            IO.println("Inga medlemmar registrerade ännu.");
        } else {
            IO.println("Flest aktiva lån: " + top);
        }
    }

    private static Integer readInt(String prompt) {
        IO.print(prompt);
        String raw = scanner.nextLine().trim();
        try {
            return Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            IO.println("Endast giltiga heltal.");
            return null;
        }
    }

    // Test
    private static void seedData() {
        bibliotek.nyBok(new Bok("999-99-9", "Sagan om Ringen", "J.R.R. Tolkien"));
        bibliotek.nyBok(new Bok("999-99-8", "Gentlemen", "Klas Östergren"));
        bibliotek.nyBok(new Bok("999-99-7", "Animal Farm", "George Orwell"));
        bibliotek.registreraMedlem("Johan");
        bibliotek.registreraMedlem("Naomi");
    }
}