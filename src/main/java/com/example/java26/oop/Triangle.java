package com.example.java26.oop;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;


    public Triangle(double v, double v1, double v2) {
        sideA = v;
        sideB = v1;
        sideC = v2;
    }
    static void main (){
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        IO.println("Perimeter: " + triangle.perimeter());

    }

    private String perimeter() {
        return String.format("%.2f", sideA + sideB + sideC);
    }
}
