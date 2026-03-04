package com.cg.service;

import java.util.List;


import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.IEmployeeDao;

public class EmployeeService implements IEmployeeService {

    private IEmployeeDao dao = new EmployeeDao();

    @Override
    public String createEmployee(Employee emp) {
        if (emp.getName() == null || emp.getName().length() < 4 || emp.getEmail() == null) {
            return "Invalid Employee Data";
        }
        return dao.saveEmployee(emp);
    }

    @Override
    public Employee findById(String empid) {
        if (empid == null)
            return null;
        return dao.findEmployee(empid);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return dao.getAll();
    }

    @Override
    public String updateEmployeeName(Employee emp) {
    	 if (emp.getEmpid() == null) {
 	        return "Employee ID is required";
 	    }
 	    return dao.updateEmployeeName(emp);
    }

    @Override
    public String removeEmployee(String empid) {
        if (empid == null || empid.isEmpty())
            return "Invalid Employee ID";

        return dao.deleteEmployee(empid);
    }
}