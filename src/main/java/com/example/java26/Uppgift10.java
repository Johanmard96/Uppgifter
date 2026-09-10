package com.example.java26;

public class Uppgift10 {
    static void main() {

        double celcius = 20.0;
                double fahrenheit = (9.0/5.0)*celcius;

        IO.println("Temperature is " + celcius + " C and " +toFahrenheit(celcius) + " F");


    }

        public static double toFahrenheit(double temp) {
            return temp * 1.8 + 32;
        }
    }
