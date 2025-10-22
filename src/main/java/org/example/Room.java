package org.example;

public class Room {

    private int numberOfBeds;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable = true;

    public Room() {

    }

    public Room(int numberOfBeds, boolean isOccupied, boolean isDirty, boolean isAvailable) {
        this.numberOfBeds = numberOfBeds;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
    }

    public void checkIn() {
        // set room occupied and make dirty
        if(!isOccupied && !isDirty){
            this.isDirty = true;
            this.isAvailable = false;
            System.out.println("Room was checked into");
        } else if(!isAvailable) {
            System.out.println("This room is not available");
        } else {
            System.out.println("This room is not ready");
        }
    }

    public void checkOut() {
        // housekeeper must clean room before another guest can check in
        if(isAvailable) {
            System.out.println("Room is not checked into yet...");
        } else {
            System.out.println("Room was checked out of");
            System.out.println("Remember to clean this room");
        }
    }

    public void cleanRoom(Employee employee) {
        if(employee.getIsClockingIn()) {
            System.out.println("Cleaning...wait 5 minutes");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Whoops, slipped on a banana " + e);
            }
            System.out.println("Room is now cleaned\n");
        } else {
            System.out.println(employee.getName() + " is not clocked in");
        }
    }

}
