package com.example.business;

import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Manager;

public class EmployeeStockPlan2 {

    private final int employeeShares = 10;
    private final int managerShares = 20;
    private final int directorShares = 100;

    public EmployeeStockPlan2() {
    }

    public int grantStock(Employee emp) {
        // Stock is granted based on the employee type
        if (emp instanceof Director) {
            return directorShares;
        } else if (emp instanceof Manager) {
            return managerShares;
        } else {
            return employeeShares;
        }
    }
}
