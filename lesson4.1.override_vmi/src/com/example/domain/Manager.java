package com.example.domain;

public class Manager extends Employee {

    private String deptName;

    public Manager(int empId, String name, String ssn, double salary, String deptName) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
    }

    @Override
    public String getDetails() {
        //private String getDetails(){
        //public String getDetails() throws Exception{
        return super.getDetails() + "\nDepartment:      " + getDeptName();
    }

    public String getDeptName() {
        return deptName;
    }
}
