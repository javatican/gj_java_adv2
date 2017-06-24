package com.example;

import com.example.business.EmployeeStockPlan;

import com.example.domain.Admin;
import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Engineer;
import com.example.domain.Manager;

public class EmployeeTest {

    public static void main(String[] args) {

        // Create the classes as per the practice
        Engineer eng = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);

        Manager mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "Marketing");

        Admin adm = new Admin(304, "Bill Munroe", "108-23-6509", 75_002.34);

        Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 100_000.00);

        // Test the EmployeeStockPlan class
        EmployeeStockPlan esp = new EmployeeStockPlan();
        printEmployee(eng, esp);
        printEmployee(adm, esp);
        printEmployee(mgr, esp);
        printEmployee(dir, esp);
        System.out.println();
        //test object equality
        Employee e1 = new Employee(401, "John Brown", "056-77-5123", 110_500.12);
        Employee e2 = e1;
        System.out.println("e1.equals(e2) = "+e1.equals(e2));
        Employee e3 = new Employee(401, "John Brown", "056-77-5123", 110_500.12);
        System.out.println("e1.equals(e3) = "+e1.equals(e3));
    }

    public static void printEmployee(Employee emp) {
        System.out.println(); // Print a blank line as a separator
        // Print out the data in this Employee object using its toString() method
        System.out.println(emp);
    }

    public static void printEmployee(Employee emp, EmployeeStockPlan esp) {
        printEmployee (emp);
        System.out.println("Stock Options:   " + esp.grantStock(emp));
    }
}