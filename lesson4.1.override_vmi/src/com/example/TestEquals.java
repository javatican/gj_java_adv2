package com.example;

import com.example.domain.Employee;

public class TestEquals {

    public static void main(String[] args) {
        Employee x = new Employee(1, "Sue", "111-11-1111", 10.0);
        Employee y = x;
         System.out.println(x.toString());
         System.out.println(y);
        System.out.println(x.equals(y));
        Employee z = new Employee (1,"Sue","111-11-1111",10.0);
        System.out.println(x.equals(z));
        System.out.println(x==z);
    }

}
