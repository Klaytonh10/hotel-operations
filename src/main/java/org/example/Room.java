package org.example;

public class Room {

    private int roomNumber;
    private int numberOfBeds;
    private double getPrice;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;

    public void Room(int roomNumber, int numberOfBeds, double getPrice, boolean isOccupied, boolean isDirty, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.getPrice = getPrice;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
    }

    public void checkIn() {
        // set room occupied and make dirty
        if(!isOccupied && !isDirty){
            this.isDirty = true;
            this.isAvailable = false;
        } else {

        }
    }

    public void checkOut() {
        // housekeeper must clean room before another guest can check in

    }

    public void cleanRoom() {

    }

}
