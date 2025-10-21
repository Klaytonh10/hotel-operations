package org.example;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public void Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public void getTotalPay() {

    }

    public void getRegularHours() {

    }

    public void getOvertimeHours() {

    }

    public void punchTimeCard(double time, boolean isClockedIn) {
        // calculate how many hours have been worked and
        // add that to their time sheet. Time clocked out - time punched in
    }

    public void cleanRoom() {

    }

}
