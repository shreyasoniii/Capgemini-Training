package com;
public class Main{
    public static void main(String[] args) {
        EmployeeService service=new EmployeeService();
        service.averageSalary();
        service.employeeWithMaxSalary();
        service.displayEmployeeNameAndSalary();
        service.sortBySalaryDescending();
        service.totalSalPerDept();

    }

}