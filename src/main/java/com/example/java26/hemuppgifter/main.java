package com.example.java26.hemuppgifter;

public class main {
    public static void main(String[] args) {
        Office office = new Office();

        // Lägg till minst fyra rum med olika kapacitet
        office.addRoom(new Room("Konferensrum A", 10));
        office.addRoom(new Room("Konferensrum B", 4));
        office.addRoom(new Room("Mötesrum C", 2));
        office.addRoom(new Room("Stora salen", 20));

        System.out.println("Totalt antal rum skapade i systemet: " + Office.getTotalRoomsCreated());
        System.out.println();

        // Boka ett par av rummen (och försök boka ett redan bokat rum)
        office.getRooms().get(0).book(); // Konferensrum A
        office.getRooms().get(2).book(); // Mötesrum C
        office.getRooms().get(0).book(); // Redan bokat -> avvisas

        System.out.println();
        printRoomStatus(office);

        System.out.println();
        Room found = office.findAvailableRoom(5);
        System.out.println(found != null
                ? "Hittade ledigt rum med kapacitet >= 5: " + found
                : "Inget ledigt rum med tillräcklig kapacitet hittades.");

        System.out.println();
        System.out.println("--- Copy constructor-demo ---");
        Room original = office.getRooms().get(1); // Konferensrum B, ledigt
        Room kopia = new Room(original);
        kopia.book();

        System.out.println("Original: " + original);
        System.out.println("Kopia:    " + kopia);

        if (!original.isBooked() && kopia.isBooked()) {
            System.out.println("OK: att boka kopian påverkade inte originalet.");
        }
    }

    private static void printRoomStatus(Office office) {
        System.out.println("Lediga rum:");
        for (Room r : office.getRooms()) {
            if (!r.isBooked()) System.out.println("  - " + r);
        }
        System.out.println("Bokade rum:");
        for (Room r : office.getRooms()) {
            if (r.isBooked()) System.out.println("  - " + r);
        }
    }
}