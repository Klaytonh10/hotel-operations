package org.example;

public class Hotel {

    // check if there are rooms available for the current day only

    private String name;
    private int numberOfRooms;
    private int numberOfSuites;
    private int bookedBasicRooms;
    private int bookedSuites;

    public Hotel(String name, int bookedBasicRooms, int bookedSuites) {

    }

    public Hotel(String name, int numberOfRooms, int numberOfSuites, int bookedBasicRooms, int bookedSuites) {

    }

    // Do not have a private backing variable
    // Calculate response based on other member variables
    public void getAvaliableSuites() {

    }

    // Do not have a private backing variable
    // Calculate response based on other member variables
    public void getAvailableSuites() {

    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        /*
        Determine if there are enough rooms available and update the booked inventory if they are

        Return true/false based on whether the rooms were able to book
        */

        return false;
    }

}
