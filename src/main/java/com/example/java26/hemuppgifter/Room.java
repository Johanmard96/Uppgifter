package com.example.java26.hemuppgifter;

/**
 * Representerar ett bokningsbart rum.
 */
public class Room {
    private String roomName;
    private int capacity;
    private boolean isBooked;

    public Room(String roomName, int capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.isBooked = false;
    }

    /**
     * Copy constructor – skapar ett helt nytt, oberoende Room-objekt
     * med samma värden som "other". Eftersom alla fält är primitiver/String
     * (immutabla) delar kopian inget tillstånd med originalet: att boka
     * kopian påverkar aldrig originalet, och tvärtom.
     */
    public Room(Room other) {
        this.roomName = other.roomName;
        this.capacity = other.capacity;
        this.isBooked = other.isBooked;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isBooked() {
        return isBooked;
    }

    /**
     * Bokar rummet – men bara om det inte redan är bokat.
     */
    public void book() {
        if (isBooked) {
            System.out.println("Kunde inte boka \"" + roomName + "\" - rummet är redan bokat.");
        } else {
            isBooked = true;
            System.out.println("\"" + roomName + "\" är nu bokat.");
        }
    }

    /**
     * Avbokar rummet – men bara om det faktiskt är bokat.
     */
    public void cancelBooking() {
        if (!isBooked) {
            System.out.println("\"" + roomName + "\" var inte bokat sedan tidigare.");
        } else {
            isBooked = false;
            System.out.println("Bokningen av \"" + roomName + "\" har avbokats.");
        }
    }

    @Override
    public String toString() {
        return roomName + " (kapacitet: " + capacity + ") - " + (isBooked ? "Bokat" : "Ledigt");
    }
}