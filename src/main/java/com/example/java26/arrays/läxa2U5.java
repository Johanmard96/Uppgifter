package com.example.java26.arrays;
import java.util.Scanner;

public class läxa2U5 {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        int hemligTal = (int)(Math.random()*100)+1;
        int gissning = 0;
        int antalGissningar = 0;

        IO.println("Gissa ett tal mellan 1 och 100: ");
        gissning = scanner.nextInt();
        antalGissningar++;

        while (gissning != hemligTal) {

            if (gissning > hemligTal) {
                IO.println("För högt, försök igen!");

            } else if (gissning < hemligTal) {
                IO.println("För lågt, försök igen!");
            }

            gissning = scanner.nextInt();
            antalGissningar++;
        }

        IO.println("Helt rätt!");
        IO.println("Antal gissningar: " + antalGissningar);
    }
}