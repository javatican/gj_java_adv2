package com.example.business;
 
import com.example.domain.Employee; 

public class EmployeeStockPlan {


    public EmployeeStockPlan() {
    }

    public int grantStock(Employee emp) {
        return emp.calculateStock();
    }
}