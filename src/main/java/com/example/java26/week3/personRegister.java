package com.example.java26.week3;

public class personRegister {

    static void main() {

        String name;
        int envelopeNumber;

        String[] names = new String[10];
        int[] eNumbers = new int[10];

        for (int i = 0; i < names.length; i++) {
            names[i] = IO.readln("Voter name:");
            eNumbers[i] = Integer.parseInt(IO.readln("Envelope number:"));
        }


    }


}
