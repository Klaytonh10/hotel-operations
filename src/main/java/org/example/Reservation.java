package org.example;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    // room type can be "king" or "double"
    // if king, price $139
    // if double, price $124
    // if weekend, price + (price * .10)

    private String roomType;
    private double price;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private boolean isWeekend;

    public Reservation(String roomType, String checkIn, String checkOut) {
        this.roomType = roomType;
        this.checkIn = LocalDateTime.parse(checkIn);
        this.checkOut = LocalDateTime.parse(checkOut);
    }

    public double getPrice() {
        if(roomType.equalsIgnoreCase("King")) {
            this.price = 139;
        } else if (roomType.equalsIgnoreCase("Double")) {
            this.price = 124;
        }
        return this.price;
    }

    public double reservationTotal() {
        if(getWeekend() == 0) {
            return getPrice() * getNumberOfNights();
        } else {
            return (getPrice() * (getNumberOfNights() - getWeekend())) + (price * 1.1) * getWeekend();
        }
    }

    public long getNumberOfNights() {
        long numberOfNights = Duration.between(checkIn, checkOut).toDays();
        return numberOfNights;
    }

    public int getWeekend() {
        int weekendCount = 0;
        LocalDate start = checkIn.toLocalDate();
        LocalDate end = checkOut.toLocalDate();
        while(!start.isAfter(end.minusDays(1))) {
            DayOfWeek day = start.getDayOfWeek();
            if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                weekendCount++;
            }
            start = start.plusDays(1);
        }
        return weekendCount;
    }
}
