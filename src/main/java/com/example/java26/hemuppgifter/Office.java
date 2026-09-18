package com.example.java26.hemuppgifter;

import java.util.ArrayList;
import java.util.List;

/**
 * Representerar ett kontor med en samling rum.
 */
public class Office {

    // Statiskt fält: delas av ALLA Office-instanser och håller koll på
    // det totala antalet rum som lagts till i hela systemet, över alla kontor.
    private static int totalRoomsCreated = 0;

    private List<Room> rooms;

    public Office() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room r) {
        rooms.add(r);
        totalRoomsCreated++;
    }

    /**
     * Returnerar det första lediga rummet med minst minCapacity i kapacitet,
     * eller null om inget sådant rum finns.
     */
    public Room findAvailableRoom(int minCapacity) {
        for (Room r : rooms) {
            if (!r.isBooked() && r.getCapacity() >= minCapacity) {
                return r;
            }
        }
        return null;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public static int getTotalRoomsCreated() {
        return totalRoomsCreated;
    }
}