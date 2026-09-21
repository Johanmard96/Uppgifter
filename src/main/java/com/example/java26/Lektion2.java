package com.example.java26;

public class Lektion2 {
    static void main() {
        /*IO.println("Hej, vad heter du?");
        String name = IO.readln();
        IO.println(name);
        IO.println("Hej " + name);
        IO.println("Hur många katter har du?");
        int catCount = Integer.parseInt( IO.readln());
        IO.println("Du har " + catCount + " katt(er)");
        IO.println("Om du skaffar en katt till har du " + ++catCount );*/
         int age = Integer.parseInt(IO.readln("What is your age?"));
         if (age <= 18) {
             IO.println("Access denied");
             return;

         }
        IO.println("Only for over 18 code");

    }
}
