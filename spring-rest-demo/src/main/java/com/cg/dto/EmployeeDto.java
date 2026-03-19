package com.cg.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class EmployeeDto {
    private int employeeeid;
    @Column(name = "name")
    private String employeename;
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate dobemp;
    private double salaryemp;

    public EmployeeDto(int employeeeid, String employeename, LocalDate dobemp, double salaryemp) {
        this.employeeeid = employeeeid;
        this.employeename = employeename;
        this.dobemp = dobemp;
        this.salaryemp = salaryemp;
    }

    public int getEmployeeeid() {
        return employeeeid;
    }

    public void setEmployeeeid(int employeeeid) {
        this.employeeeid = employeeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public LocalDate getDobemp() {
        return dobemp;
    }

    public void setDobemp(LocalDate dobemp) {
        this.dobemp = dobemp;
    }

    public double getSalaryemp() {
        return salaryemp;
    }

    public void setSalaryemp(double salaryemp) {
        this.salaryemp = salaryemp;
    }
}
