package com.cg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;

public class EmployeeDao implements IEmployeeDao{
	private static Connection con;
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","shreya123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String saveEmployee(Employee emp) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?)");
			ps.setString(1, emp.getEmpid());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getDob());
			int rows=ps.executeUpdate();
			if(rows>0)
				return "Employee Created";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Employee Not Created";
	}
	@Override
	public Employee findEmployee(String empid) {
		// TODO Auto-generated method stub
		Employee emp=null;
		try {

			PreparedStatement ps=con.prepareStatement("Select * from Employee where empid=?");
			ps.setString(1,empid);


			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				emp =new Employee(
						rs.getString("empid"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("dob")

				);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;


	}





	@Override
	public List<Employee> getAll() {
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM employee"
			);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Employee emp = new Employee();

				emp.setEmpid(rs.getString("empid"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setDob(rs.getString("dob"));

				list.add(emp);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}


	@Override
	public String updateEmployeeName(String empid, String newName) {
        String result;
        // TODO Auto-generated method stub
		int rows=0;
		try {
			PreparedStatement ps=con.prepareStatement("Update Employee set name=? where empid=?");
			ps.setString(1, newName);
			ps.setString(2, empid);
			rows=ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows>0) {
            result = "Updated";
        }
		else {
            result = "Failed to update.";
        }
        return result;
    }
	@Override
	public String deleteEmployee(String empid) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"DELETE FROM employee WHERE empid = ?"
			);

			ps.setString(1, empid);

			int rows = ps.executeUpdate();

			if (rows > 0)
				return "Employee Deleted";

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return "Employee Not Found";
	}
}
