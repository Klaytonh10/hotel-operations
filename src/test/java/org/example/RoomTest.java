package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void test_check_in_unoccupied() {
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
    void test_check_out_clean_and_unoccupied() {
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
    void test_clean_room_without_employee_while_clean() {
        // Arrange
        Room room1 = new Room();
        // Act
        String expected = "this room is already clean";
        String actual = room1.cleanRoom();
        // Assert
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void test_clean_room_while_dirty() {

        // Arrange
        Room room1 = new Room();
        room1.isDirty = true;

        // Act
        String expected = "Room is now cleaned";
        String actual = room1.cleanRoom();

        // Assert
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void test_clean_room_with_employee() {
        // Arrange
        Room room1 = new Room();
        Employee john = new Employee("001", "john", "cleaning", 1.25, 00);
        john.punchIn(9.30);
        // Act
        String expected = "Room is now cleaned";
        String actual = room1.cleanRoom(john);
        // Assert
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}