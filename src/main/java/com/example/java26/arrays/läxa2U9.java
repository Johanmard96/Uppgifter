package com.example.java26.arrays;
import java.util.Scanner;

public class läxa2U9 {
    static void main() {

        Scanner scanner = new Scanner(System.in);

        IO.println("Skriv en mening: ");
        String mening = scanner.nextLine();

        // Antal tecken
        IO.println("Antal tecken: " + mening.length());

        // Versaler
        IO.println("Versaler: " + mening.toUpperCase());

        // Baklänges
        String baklanges = new StringBuilder(mening).reverse().toString();
        IO.println("Baklänges: " + baklanges);

        // Innehåller "Java"?
        if (mening.contains("Java")) {
            IO.println("Meningen innehåller ordet \"Java\".");
        } else {
            IO.println("Meningen innehåller inte ordet \"Java\".");
        }

        scanner.close();
    }
}