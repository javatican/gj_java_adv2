package com.example;

import com.example.domain.Employee;
import com.example.domain.Manager;
import java.text.NumberFormat;

public class EmployeeTest {

    public static void main(String[] args) {

        // Create the classes as per the practice
        Employee e = new Employee(101, "Jane Smith", "012-34-5678", 120_345.27);

        Manager m = new Manager(207, "Barbara Johnson", "054-12-2367", 209_501.36, "US Marketing");

        System.out.println(e.getDetails());
        System.out.println("===============================");
        System.out.println(m.getDetails());
        // virtual method invocation
        Employee e2 = new Manager(207, "Barbara Johnson", "054-12-2367", 209_501.36, "US Marketing");
        System.out.println("===============================");
        System.out.println(e2.getDetails());
    }

    public static void printEmployee(Employee emp) {
        System.out.println(); // Print a blank line as a separator
        // Print out the data in this Employee object
        if (emp instanceof Manager) {
            System.out.println("It's TRUE============================");
        }
        System.out.println("Employee id:         " + emp.getEmpId());
        System.out.println("Employee name:       " + emp.getName());
        System.out.println("Employee Soc Sec #:  " + emp.getSsn());
        System.out.println("Employee salary:     " + NumberFormat.getCurrencyInstance().format((double) emp.getSalary()));
    }
}
