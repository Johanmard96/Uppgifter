package com.example.java26.arrays;

public class läxa2U6 {
    static void main() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (x == y)
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println("");
        }
    }
}