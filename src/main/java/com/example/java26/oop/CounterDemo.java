package com.example.java26.oop;

public class CounterDemo {

    static void main() {
        Counter counter = new Counter();

        counter.increment();
        counter.increment();
        counter.increment();
        counter.decrement();

        IO.println(counter.getCounter());


        Counter counter2 = new Counter();

        IO.println(counter.getCounter());
        IO.println(counter2.getCounter());
        IO.println(Counter.getInstances());
    }
}
