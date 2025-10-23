package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private boolean isClockingIn = false;
    private double timeIn;
    private double timeOut;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return this.name;
    }

    public double getTotalPay() {

        double normalPay = hoursWorked * payRate;
        double overtimePay = payRate * 1.5;
        double overtimeHours = hoursWorked - 40;

        if(overtimeHours > 0) {
            return normalPay + (overtimePay * overtimeHours);
        } else {
            return normalPay;
        }
    }

    public double getTotalPay(double hours) {

        double normalPay = hours * payRate;
        double overtimePay = payRate * 1.5;
        double overtimeHours = hours - 40;

        if(overtimeHours > 0) {
            return normalPay + (overtimePay * overtimeHours);
        } else {
            return normalPay;
        }
    }

    public boolean getIsClockingIn() {
        return this.isClockingIn;
    }

    public double getRegularHours() {
        return hoursWorked;
    }

    public void getOvertimeHours() {
        double overtimeHours = hoursWorked - 40;
        if(overtimeHours > 0){
            System.out.println("Overtime");
        }
    }

    public void punchTimeCard(boolean isClockingIn) {
        // calculate how many hours have been worked and
        // add that to their time sheet. Time clocked out - time punched in

        if(isClockingIn){
            this.isClockingIn = isClockingIn;
            System.out.println(this.name + " is now clocked in");
        } else {
            this.isClockingIn = false;
            System.out.println(this.name + " is now clocked out");
        }

    }

    public void punchTimeCard(double time, boolean isClockingIn) {
        // calculate how many hours have been worked and
        // add that to their time sheet. Time clocked out - time punched in
        if(isClockingIn){
            this.isClockingIn = isClockingIn;
            this.timeIn = time;
            System.out.println(this.name + " is now clocked in\n");
        } else {
            this.isClockingIn = false;
            System.out.println(this.name + " is now clocked out");
            this.timeOut = time;
            double hoursWordedToday = timeOut - timeIn;
            System.out.println(this.name + " made $" + getTotalPay(hoursWordedToday) + " today\n");
        }

    }

}
