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
    private String inTime;
    private String outTime;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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

    public double getRegularHours() {
        return hoursWorked;
    }

    public void getOvertimeHours() {
        double overtimeHours = hoursWorked - 40;
        if(overtimeHours > 0){
            System.out.println("Overtime");
        }
    }

    public void punchTimeCard(double time, boolean isClockingIn) {
        // calculate how many hours have been worked and
        // add that to their time sheet. Time clocked out - time punched in
        double todayTime;
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeNow = now.format(formatter);
        if(isClockingIn){
            this.isClockingIn = isClockingIn;
            this.inTime = timeNow;
        } else {
            this.isClockingIn = false;
            this.outTime = timeNow;
            long timeBetween = Duration.between(inTime, outTime);
            System.out.println(this.name + " worked for " + this.hoursWorked + " hours");
        }

    }

    public void cleanRoom() {
        if(isClockingIn) {
            System.out.println("Cleaning...wait 5 minutes");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Whoops, slipped on a banana " + e);
            }
            System.out.println("Room is now cleaned");
        } else {
            System.out.println("Not clocked in");
        }
    }

}
