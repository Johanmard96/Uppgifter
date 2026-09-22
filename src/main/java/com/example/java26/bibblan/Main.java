package com.example.java26.bibblan;

import java.util.Scanner;

/*
CLI för bibliotekshanteraren.
Loopar tills användaren avslutar.
 */


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bibliotek bibliotek = new Bibliotek();

    public void main () {
        seedData();

        boolean running = true;
        while (running) {
            printMenu();
            String input = scanner.nextLine().trim();
        }
    }

}