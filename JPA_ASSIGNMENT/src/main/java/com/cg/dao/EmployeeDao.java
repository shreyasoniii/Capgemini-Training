package com.cg.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;

import jakarta.persistence.*;
import jakarta.transaction.Transaction;

public class EmployeeDao implements IEmployeeDao{
	private static EntityManager em;
	static {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
		em=emf.createEntityManager();
		
	}
	@Override
	public String saveEmployee(Employee emp) {
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		em.persist(emp);
		txn.commit();
		return "Employee Created";
	}

	@Override
	public Employee findEmployee(String empid) {
		// TODO Auto-generated method stub
		
		Employee employee=em.find(Employee.class, empid);
		return employee;

	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("Select Employee from Employee");
		List<Employee> list= q.getResultList();
		return list;
		
		
	}

	@Override
	public String updateEmployeeName(Employee emp) {
		// TODO Auto-generated method stub
		
		  Employee employee = em.find(Employee.class, emp.getEmpid());

		    if (employee != null) {
		        em.getTransaction().begin();
		        employee.setName(emp.getName());
		        employee.setDob(emp.getDob());
		        employee.setEmail(emp.getEmail());
		        em.getTransaction().commit();
		        return "Employee Details Updated.";
		    } else {
		        return "Not Updated.";
		    }
		
	}

	@Override
	public String deleteEmployee(String empid) {
		// TODO Auto-generated method stub
		
		Employee emp=em.find(Employee.class,empid);
		if(emp!=null) {
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
			return "deleted";
		}
		else {
			return "not deleted";
		}
	}
}
