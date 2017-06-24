package com.example.business;
 
import com.example.domain.Employee; 

public class EmployeeStockPlan3 {

    private final int employeeShares = 10;
    private final int managerShares = 100;
    private final int directorShares = 1000;

    public EmployeeStockPlan3() {
    }

    public int grantStock(Employee emp) {
        return emp.calculateStock();
    }
}