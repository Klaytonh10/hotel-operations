package org.example;

public class Room {

    private int numberOfBeds;
    boolean isOccupied;
    boolean isDirty;
    private boolean isAvailable = true;

    public Room() {

    }

    public Room(int numberOfBeds, boolean isOccupied, boolean isDirty, boolean isAvailable) {
        this.numberOfBeds = numberOfBeds;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
    }

    public boolean checkIn() {
        // set room occupied and make dirty
        if(!isOccupied && !isDirty){
            this.isDirty = true;
            this.isOccupied = true;
            this.isAvailable = false;
            System.out.println("Room was checked into");
            return true;
        } else if(!isAvailable) {
            System.out.println("This room is not available");
            return false;
        } else {
            System.out.println("This room is not ready");
            return false;
        }
    }

    public boolean checkOut() {
        // housekeeper must clean room before another guest can check in
        if(isAvailable) {
            System.out.println("Room is not checked into yet...");
            return false;
        } else {
            this.isOccupied = false;
            System.out.println("Room was checked out of");
            System.out.println("Remember to clean this room");
            return true;
        }
    }

    public String cleanRoom() {
        String message;
        if(!this.isOccupied && this.isDirty) {
            System.out.println("cleaning...wait 5 minutes");
            try {
                Thread.sleep(1000);
                System.out.println("\uD83E\uDDFC");
                Thread.sleep(1000);
                System.out.println("\uD83E\uDDF9");
                Thread.sleep(1000);
                System.out.println("\uD83E\uDDFA");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Whoops, slipped on a banana " + e);
            }
            message = "Room is now cleaned";
            this.isAvailable = true;
            this.isDirty = false;
            return message;
        } else if(this.isOccupied) {
            message = "this room is occupied";
            return message;
        } else if(!this.isDirty) {
            message = "this room is already clean";
            return message;
        } else {
            return "error cleaning room";
        }
    }

    public String cleanRoom(Employee employee) {
        String message;
        if(employee.getIsWorking() && !this.isOccupied && this.isDirty) {
            System.out.println(employee.getName() + " is cleaning...wait 5 minutes");
            try {
                Thread.sleep(1000);
                System.out.println("\uD83E\uDDFC");
                Thread.sleep(1000);
                System.out.println("\uD83E\uDDF9");
                Thread.sleep(1000);
                System.out.println("\uD83E\uDDFA");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Whoops, slipped on a banana " + e);
            }
            message = "Room is now cleaned";
            this.isAvailable = true;
            this.isDirty = false;
            return message;
        } else if(this.isOccupied) {
            message = "this room is occupied";
            return message;
        } else if(!this.isDirty) {
            message = "this room is already clean";
            return message;
        } else {
            message = employee.getName() + " is not clocked in";
            return message;
        }
    }

}
