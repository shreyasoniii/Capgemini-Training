package com.cg.main;

import com.cg.bean.Book;
import com.cg.bean.Librarian;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookMain {
    public static void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Librarian librarian = (Librarian) context.getBean("lib");
        librarian.issueBook();

        ApplicationContext ctx= new ClassPathXmlApplicationContext("beanConstructor.xml");
        Librarian librarian2 = (Librarian) ctx.getBean("lib");
        librarian2.issueBook();

    }

}
