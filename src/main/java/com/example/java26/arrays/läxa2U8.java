package com.example.java26.arrays;

record Person(String namn, int alder, String stad) {
}

public class läxa2U8 {

    static void main() {

        Person person1 = new Person("Glenn", 67, "Göteborg");
        Person person2 = new Person("Johan", 29, "Kolbergsbo");
        Person person3 = new Person("Anastasia", 19, "Kvarntäkt");

        IO.println(person1.namn() + ", " + person1.alder() + ", " + person1.stad());
        IO.println(person2.namn() + ", " + person2.alder() + ", " + person2.stad());
        IO.println(person3.namn() + ", " + person3.alder() + ", " + person3.stad());
    }
}

