package com.cg.main;

import com.cg.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld h1=(HelloWorld) ctx.getBean("hello");
        HelloWorld h2=(HelloWorld)ctx.getBean("hello");
//        System.out.println(h1.sayHello("Shreya"));
//        System.out.println(h2.sayHello("Shreya"));
//        //Ioc container make single object that why its give true
//        System.out.println(h==h2);
        //if we want to make not single object we do


        System.out.println(h1.sayHello());
        System.out.println(h1.getLang());
        ((ClassPathXmlApplicationContext)ctx).close();

    }
}
