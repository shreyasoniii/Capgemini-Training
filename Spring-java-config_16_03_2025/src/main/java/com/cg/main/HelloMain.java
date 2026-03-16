package com.cg.main;

import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;
import com.cg.confi.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class HelloMain{
    public static void main(String[] args) {
        ApplicationContext ct=new AnnotationConfigApplicationContext(MyConfig.class);
//        HelloWorld h1=(HelloWorld)ct.getBean("h");
//        HelloWorld h2=(HelloWorld)ct.getBean("h") ;
//       // HelloWorld h=ct.getBean
//        System.out.println(h1.sayHello("shriya"));
//        System.out.println(h2.sayHello("shriya"));
//        System.out.println(h1==h2);
        Employee e=ct.getBean(Employee.class);
        e.printEmployeeDetails();



    }
}