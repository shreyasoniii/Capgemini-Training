package com.cg.pl;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

import java.sql.SQLOutput;
import java.util.List;

public class EmployeeMain {

	public static void main(String[] args) {
		IEmployeeService es=new EmployeeService();
		String result=es.createEmployee(new Employee("20","pRiya", "pr@gmail.com", "1991-06-26"));
		System.out.println(result);

		Employee emp=es.findById("1");
		System.out.println(emp);

		List<Employee> Employee=es.getAllEmployee();
	    System.out.println(Employee);

 	     String UpdateEmp=es.updateEmployeeName("1","Shriya");
	     System.out.println(UpdateEmp);

		String RemoveEmp=es.removeEmployee("1");
		System.out.print(RemoveEmp);



	}

}
