package com.example.java26.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleIntegers {
    private int[] values = new int[10];
    private int counter = 0;


    public void add(int value) {
        if(counter >= values.length) {
            growArray();
        }

        values[counter++] = value;
    }

    public void addFirst(int value) {
        if (counter >= values.length) {
            growArray();
        }

        for (int i = counter - 1; i >= 0; i++) {
            values[i + 1] = values[i];
        }
    }

    private void growArray() {

        //Arrays.copyOf(values, values.length*2);

        int[] temp = new int[values.length * 2];

        for(int i = 0; i < values.length; i++) {
            temp[i] = values[i];
        }

        values = temp;

    }

    public int getValue(int index) {
        return values[index];
    }

    public void removeLast() {
        counter--;
    }


    public void removeAtIndex(int index) {
        for(int i = index; i < counter; i++) {
            values[i] = values[i + 1];
        }

    }

    public int size() {
        return counter;
    }

    public void sort() {
        Arrays.sort(values);
    }

    static void main() {
        var list = new ArrayList<Integer>();
        list.add(1);
        list.size();

        MultipleIntegers integers = new MultipleIntegers();
        integers.add(0);
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
        integers.add(50);
        integers.add(60);
        integers.add(70);
        integers.add(80);
        integers.add(90);
        integers.add(100);
        integers.add(110);
        integers.add(120);
        integers.add(130);
        integers.add(140);
        integers.add(150);
        integers.add(160);
        integers.add(170);
        integers.removeLast();
        integers.removeAtIndex(11);
        IO.println(integers.getValue(0));
        IO.println(integers.getValue(3));
        IO.println(integers.getValue(7));

        for (int i = 0; i < integers.size(); i++) {
            IO.println(integers.getValue(i));
        }

    }

}
