package com.cg.service;

import java.util.List;
import com.cg.bean.Employee;

public interface IEmployeeService {

    String createEmployee(Employee emp);

    Employee findById(String empid);

    List<Employee> getAllEmployee();

    String updateEmployeeName(Employee emp);

    String removeEmployee(String empid);
}