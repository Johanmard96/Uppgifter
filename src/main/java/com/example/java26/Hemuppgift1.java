package com.example.java26;

public class Hemuppgift1 {static void main(String[] args) {

    /*IO.println("Hej, vad heter du?");
    String name = IO.readln();
    IO.println(name);
    IO.println("Hej " + name +"!");*/


    /*double width = Double.parseDouble(IO.readln("Ange bredden för din rektangel"));
    double height = Double.parseDouble(IO.readln("Ange höjden för din rektangel"));
    var area = width * height;
    IO.println("Arean av din rektangel är " +area + " enheter");*/


    /*int age = Integer.parseInt(IO.readln("Hur gammal är du?"));
    if (age>=18) {
        IO.println("Du är gammal nog att ta körkort!");
    }
        else {
            IO.println("Du behöver vänta " + (18 - age) + " år till innan du får ta körkort.");
        }*/


    /*int tal1 = Integer.parseInt(IO.readln("Skriv in ett tal: "));
    int tal2 = Integer.parseInt(IO.readln("Skriv in ett annat tal: "));
    double medel = (tal1 + tal2) / 2.0;
    if (tal1 > tal2)
    {
        IO.println(tal1 + " är störst " + medel + " är ditt medelvärde");
    } else {
        IO.println(tal2 + " är sörts och " + medel + " är ditt medelvärde");
    }*/


    /*int tal1 = Integer.parseInt(IO.readln("Skriv in ett tal: "));
    int tal2 = Integer.parseInt(IO.readln("Skriv in ett tal till: "));
    int tal3 = Integer.parseInt(IO.readln("Skriv in ett sista tal: "));
    double medel = (tal1 + tal2 + tal3)/3.0;
    if (tal1 > tal2 && tal1 > tal3)
    {
        IO.println(tal1 + " är störst " + medel + " är ditt medelvärde");
    } else if (tal2 > tal1 && tal2 > tal3)
    {
        IO.println(tal2 + " är störst och " + medel + " är ditt medelvärde");
    } else
    {
        IO.println(tal3 + " är störst och " + medel + " är ditt medelvärde");
    }*/

    /*int tal = Integer.parseInt(IO.readln("Skriv in en siffra: "));

    if (tal > 0)
    {
        IO.println("Ditt tal är positivt!");
    } else if (tal < 0)
    {
        IO.println("Ditt tal är negativt!");
    } else {
        IO.println("Ditt tal = 0");
    }*/

    /*int tal = Integer.parseInt(IO.readln("Var god ange en siffra: "));
    if (tal % 2 == 0)
    {
        IO.println("Ditt tal är jämnt!");
    }
    else {
        IO.println("Ditt tal är ojämnt");
    }*/

    int tal1 = Integer.parseInt(IO.readln("Skriv in en siffra tack:" ));
    int tal2 = Integer.parseInt(IO.readln("Skriv in en siffra till tack:"));

    int temp1 = tal1;
        tal1 = tal2;

        tal2 = temp1;
                            IO.println("Switcheroo " + tal1 + " " + tal2);

}



}
