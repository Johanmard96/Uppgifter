package com.example.java26.arrays;

public class läxa2U7 {
static void main() {

        int[] numbers = {5, 12, 8, 21, 3};

        int summa = 0;
        int största = numbers[0];
        int minsta = numbers[0];

        for (int i = 0; i < numbers.length; i++) {


            summa += numbers[i];


            if (numbers[i] > största) {
                största = numbers[i];
            }


            if (numbers[i] < minsta) {
                minsta = numbers[i];
            }
        }

        IO.println("Summan är: " + summa);
        IO.println("Största värdet är: " + största);
        IO.println("Minsta värdet är: " + minsta);
    }
}


