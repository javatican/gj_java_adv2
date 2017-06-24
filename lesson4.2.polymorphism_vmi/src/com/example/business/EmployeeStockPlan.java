package com.example.business;

import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Manager;

public class EmployeeStockPlan {

    private final int employeeShares = 10;
    private final int managerShares = 20;
    private final int directorShares = 100;

    public EmployeeStockPlan() {
    }

    public int grantStock(Employee e) {
        return employeeShares;
    }

    public int grantStock(Manager m) {
        return managerShares;
    }

    public int grantStock(Director d) {
        return directorShares;
    }
}
