package com.cg.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

public class EmployeeMain {

    public static void main(String[] args) {

        IEmployeeService es = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        while (true) {
          
            System.out.println("1. Create Employee");
            System.out.println("2. Find Employee by ID");
            System.out.println("3. Get All Employees");
            System.out.println("4. Update Employee Name");
            System.out.println("5. Delete Employee");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

            case 1:
            	System.out.print("Enter New Empid: ");
                String empid = sc.nextLine();
                
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter new Email: ");
                String email = sc.nextLine();

                System.out.print("Enter new DOB (yyyy-mm-dd): ");
                String dob = sc.nextLine();

                Employee emp = new Employee(empid,name, email, dob);
                System.out.println(es.createEmployee(emp));
                break;

            case 2:
                System.out.print("Enter Employee ID: ");
                String id = sc.nextLine();

                Employee e = es.findById(id);
                if (e != null)
                    System.out.println(e);
                else
                    System.out.println("Employee not found");
                break;

            case 3:
                List<Employee> list = es.getAllEmployee();
                if (list.isEmpty())
                    System.out.println("No employees found");
                else
                    list.forEach(System.out::println);
                break;

            case 4:
            	Employee e1 = new Employee();

            	System.out.print("Enter Employee ID: ");
            	e1.setEmpid(sc.next());

            	System.out.println("What do you want to update?");
            	System.out.println("1. Name");
            	System.out.println("2. DOB");
            	System.out.println("3. Email");

            	int ch = sc.nextInt();


            	switch (ch) {
            	case 1:
            	    System.out.print("Enter new Name: ");
            	    e1.setName(sc.nextLine());
            	    break;

            	case 2:
            	    System.out.print("Enter new DOB: ");
            	    e1.setDob(sc.nextLine());
            	    break;

            	case 3:
            	    System.out.print("Enter new Email: ");
            	    e1.setEmail(sc.nextLine());
            	    break;

            	default:
            	    System.out.println("Invalid choice");
            	    return;
            	}

            	System.out.println(es.updateEmployeeName(e1));
            	break;

            case 5:
                System.out.print("Enter Employee ID: ");
                String delId = sc.nextLine();

                System.out.println(es.removeEmployee(delId));
                break;


            default:
                System.out.println("Invalid choice");
            }
        }
    }
}