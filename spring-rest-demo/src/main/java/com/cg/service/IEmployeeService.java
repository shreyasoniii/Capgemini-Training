package com.cg.service;

import com.cg.dto.EmployeeDto;
import com.cg.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployees();
    public Employee createEmployee(Employee employee);
    public EmployeeDto getEmployee(int id);
    public Employee updateEmployee(Employee employee);
    public String removeEmployee(int id);
    public List<Employee> getEmployeeByName(String empname);
}
