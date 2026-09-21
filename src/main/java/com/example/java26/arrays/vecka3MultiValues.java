package com.example.java26.arrays;

public class vecka3MultiValues {
    static void main() {
        int[] numbers = new int[10];
        int count = 0;
        while (count < numbers.length) {

            int number = Integer.parseInt(IO.readln( "Enter a number:"));
            numbers[count++] = number;
        }

        for (int i = 0; i < numbers.length; i++) {
            IO.print(numbers[i] + ",");
        }

    }
}
