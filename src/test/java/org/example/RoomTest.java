package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void test_check_in() {
        // Arrange
        Room room1 = new Room();

        // Act
        boolean actual = room1.checkIn();

        // Assert
        assertTrue(actual);
        assertTrue(room1.isDirty);
        assertTrue(room1.isOccupied);
    }

    @Test
    void test_check_out() {
        // Arrange
        Room room1 = new Room();

        // Act
        room1.checkIn();
        boolean actual = room1.checkOut();

        // Assert
        assertTrue(actual);
    }

    @Test
    void test_check_in_occupied() {
        // Arrange
        Room room1 = new Room();

        // Act
        room1.isOccupied = true;
        room1.isDirty = true;
        boolean actual = room1.checkIn();

        // Assert
        assertFalse(actual);
        assertTrue(room1.isDirty);
        assertTrue(room1.isOccupied);
    }

    @Test
    void test_clean_room() {
        // Arrange
        Room room1 = new Room();
        Employee john = new Employee("001", "john", "cleaning", 1.25, 00);
        john.punchTimeCard(true);
        // Act
        String expected = "Room is now cleaned\n";
        String actual = room1.cleanRoom(john);
        // Assert
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}