package com.cg.main;

import com.cg.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        Employee employee=(Employee)context.getBean("employee");
        employee.printEmployeeDetails();
    }
}
