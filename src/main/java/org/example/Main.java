package org.example;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // Duration.between

        Employee fanuel = new Employee("001", "Fanuel", "Door mat", 16, 45);
        fanuel.punchTimeCard(11.50, true);
        fanuel.cleanRoom();
        fanuel.punchTimeCard(23.00, false);
    }
}