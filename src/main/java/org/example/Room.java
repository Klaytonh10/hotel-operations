package org.example;

public class Room {

    private int numberOfBeds;
    private double getPrice;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;

    public void Room(int numberOfBeds, double getPrice, boolean isOccupied, boolean isDirty, boolean isAvailable) {
        this.numberOfBeds = numberOfBeds;
        this.getPrice = getPrice;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
    }

}
