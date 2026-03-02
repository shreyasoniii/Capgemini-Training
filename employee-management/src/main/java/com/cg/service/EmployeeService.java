package com.cg.service;

import java.util.List;
import java.util.Random;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.IEmployeeDao;

public class EmployeeService implements IEmployeeService {
	IEmployeeDao dao=new EmployeeDao();

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
	public String updateEmployeeName(String eid, String name) {
		if (eid == null || name == null || name.isEmpty())
			return "Invalid input";

		return dao.updateEmployeeName(eid, name);
	}

	@Override
	public String removeEmployee(String empid) {

		if (empid == null) {
			return "Invalid-ID";
		}

		return dao.deleteEmployee(empid);
	}

}
