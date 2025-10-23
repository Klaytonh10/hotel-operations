package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void test_punch_in() {

        // Arrange
        Employee john = new Employee("001", "john", "cleaning", 1.25, 00);

        // Act
        boolean actual = john.punchIn(8.30);
        // Assert
        assertTrue(actual);
        assertTrue(john.getIsWorking());
    }

    @Test
    void test_punch_out() {

        // Arrange
        Employee john = new Employee("001", "john", "cleaning", 12.40, 00);

        // Act
        john.punchIn(8.30);
        boolean actual = john.punchOut(16.30);
        // Assert
        assertFalse(actual);
        assertFalse(john.getIsWorking(), "Not supposed to be working after punch out");
    }

    @Test
    void test_punch_timecard() {

        // Test for double

        // Arrange
        Employee john = new Employee("001", "john", "cleaning", 12.40, 00);

        // Act
        double timeIn = 8.30;
        double timeOut = 12.30;
        double timeWorked = timeOut - timeIn;
        String actual = john.punchTimeCard(timeIn, timeOut);
        String expected = john.getName() + " made $" + john.getTotalPay(timeWorked) + " today";

        // Assert
        assertEquals(actual, expected);
    }

}