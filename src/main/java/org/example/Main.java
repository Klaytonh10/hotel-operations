package org.example;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalTime now = LocalTime.now();

        Employee fanuel = new Employee("001", "Fanuel", "Door mat", 16, 45);
        System.out.println(fanuel.getTotalPay());
        fanuel.punchTimeCard(12.50, true);
        fanuel.cleanRoom();
    }
}