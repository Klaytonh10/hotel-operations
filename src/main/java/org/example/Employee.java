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

    private boolean isWorking = false;
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

    public boolean getIsWorking() {
        return this.isWorking;
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

    // use same parameters of punchIn() and punchOut()

    public boolean punchIn(double time) {
        if (!isWorking) {
            this.isWorking = true;
            this.timeIn = time;
        }
        return this.isWorking;
    }

    public boolean punchOut(double time) {
        if(isWorking) {
            this.isWorking = false;
            this.timeOut = time;
        }
        return this.isWorking;
    }


    public String punchTimeCard(double timeIn, double timeOut) {
        // calculate how many hours have been worked and
        // add that to their time sheet. Time clocked out - time punched in
        double hoursWorkedToday = timeOut - timeIn;
        String message = this.name + " made $" + getTotalPay(hoursWorkedToday) + " today";
        System.out.println(message + "\n");
        return message;

    }

}
