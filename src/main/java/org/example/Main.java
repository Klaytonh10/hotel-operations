package org.example;

public class Main {

    public static void main(String[] args) {


        // Duration.between
        Reservation reservation = new Reservation("king", "2025-10-25T14:00:00", "2025-10-29T16:00:00");
        System.out.println(reservation.reservationTotal());
    }
}