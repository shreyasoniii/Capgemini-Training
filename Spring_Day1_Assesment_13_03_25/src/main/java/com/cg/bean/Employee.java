package com.cg.bean;

public class Employee {

    int employeeId;
    String employeeName;
    Double salary;

    public SBU getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(SBU businessUnit) {
        this.businessUnit = businessUnit;
    }

    //    String bussinessUnit;
       private SBU businessUnit;

    int age;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, SBU bussinessUnit, Double salary, int age) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.businessUnit=bussinessUnit;
        this.salary = salary;
        this.age = age;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

//    public String getBussinessUnit() {
//        return bussinessUnit;
//    }
//
//    public void setBussinessUnit(String bussinessUnit) {
//        this.bussinessUnit = bussinessUnit;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printEmployeeDetails(){
        System.out.println("EmployeeId: " + getEmployeeId());
        System.out.println("EmployeeName: " + getEmployeeName());
        System.out.println("EmployeeSalary: " + getSalary());
        System.out.println("EmployeeAge: " + getAge());
        System.out.println("BusinessUnit: " + getBusinessUnit());
    }
}