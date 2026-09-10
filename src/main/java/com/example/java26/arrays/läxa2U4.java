package com.example.java26.arrays;

import java.util.Scanner;

public class läxa2U4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resultat = "";
        String input = "";

        IO.println("Skriv nånting!: ");
        input = scanner.nextLine();

        while (!input.equals("") && !input.equals(".")) {

            if (!resultat.equals("")) {
                resultat += " ";
            }

            resultat += input;

            IO.println("Skriv nånting!: ");
            input = scanner.nextLine();
        }

        IO.println(resultat);
    }
}