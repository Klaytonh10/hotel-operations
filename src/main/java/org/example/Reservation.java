package org.example;

public class Reservation {
    // room type can be "king" or "double"
    // if king, price $139
    // if double, price $124
    // if weekend, price + (price * .10)

    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;
    private int getReservationTotal;


}
