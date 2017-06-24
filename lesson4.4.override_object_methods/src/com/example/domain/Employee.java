package com.example.domain;

import java.text.NumberFormat;
import java.util.Objects;

public class Employee {

    private int empId;
    private String name;
    private String ssn;
    private double salary;

    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public int calculateStock() {
        return 10;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        // Make sure the name value is not null or empty
        if (name != null && !name.equals("")) {
            this.name = name;
        }
    }

    public void raiseSalary(double increase) {
        // Make sure the increase is not less than 0
        if (increase > 0) {
            salary += increase;

        }
    }

    @Override
    public String toString() {
        return "Employee type:   " + getClass().getSimpleName() + "\n"
                //"Employee type:   " + getClass().getName() + "\n"
                + "Employee ID:     " + getEmpId() + "\n"
                + "Employee Name:   " + getName() + "\n"
                + "Employee SSN:    " + getSsn() + "\n"
                + "Employee Salary: " + NumberFormat.getCurrencyInstance().format(getSalary());
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof Employee) {
            Employee e = (Employee) o;
            if (this.getEmpId() == e.getEmpId()
                    && this.getName().equals(e.getName())
                    && this.getSsn().equals(e.getSsn())
                    && this.getSalary() == e.getSalary()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.empId;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.ssn);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }
}
