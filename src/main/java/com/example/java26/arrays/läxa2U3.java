package com.example.java26.arrays;

public class läxa2U3 {

    public static int countTrue(boolean[] array) {
        int count = 0;

        for (boolean b : array) {
            if (b) {
                count++;
            }
        }

        return count;
    }
    static void main(){
        boolean[] array1 = {true, false, false, true, true};
        boolean[] array2 = {false, false, false, false};
        boolean[] array3 = {};

        IO.println(countTrue(array1));
        IO.println(countTrue(array2));
        IO.println(countTrue(array3));
    }
}