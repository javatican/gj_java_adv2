package com.example.business;

import com.example.domain.Employee;

public class EmployeeStockPlan3 {

    public EmployeeStockPlan3() {
    }

    public int grantStock(Employee emp) {
        return emp.calculateStock();
    }
}
