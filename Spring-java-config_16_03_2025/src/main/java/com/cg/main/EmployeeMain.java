package com.cg.main;

import com.cg.bean.Employee;
import com.cg.confi.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeMain {
    static void main() {
        ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        Employee e=(Employee)context.getBean(Employee.class);
        e.printEmployeeDetails();
    }
}
