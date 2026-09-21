package com.example.java26.oop;

public class Counter {
    private int counter = 0;

    private static int instances = 0;

    public Counter() {
        Counter.instances++;
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public static int getInstances() {
        return instances;
    }

    static void main(){

    }
}
