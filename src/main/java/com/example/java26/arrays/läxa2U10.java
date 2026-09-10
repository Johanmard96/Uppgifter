package com.example.java26.arrays;

public class läxa2U10 {
    public static class Calc {

        // 2 st int
        public int sum(int a, int b) {
            return a + b;
        }

        // 3 st int
        public int sum(int a, int b, int c) {
            return a + b + c;
        }

        // int[]
        public int sum(int[] tal) {
            int summa = 0;
            for (int t : tal) {
                summa += t;
            }
            return summa;
        }

        // String, t.ex. "1234" -> 1+2+3+4 = 10
        public int sum(String tal) {
            int summa = 0;
            for (char c : tal.toCharArray()) {
                if (Character.isDigit(c)) {
                    summa += Character.getNumericValue(c);
                }
            }
            return summa;
        }

        public static void main(String[] args) {
            Calc calc = new Calc();

            System.out.println(calc.sum(2, 3));                 // 5
            System.out.println(calc.sum(2, 3, 4));               // 9
            System.out.println(calc.sum(new int[]{1, 2, 3, 4})); // 10
            System.out.println(calc.sum("1234"));                // 10
        }
    }
}