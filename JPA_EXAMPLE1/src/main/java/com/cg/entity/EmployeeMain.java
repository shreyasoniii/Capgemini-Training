package com.cg.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;

public class EmployeeMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        PEmployee obj=new PEmployee();
        obj.setName("Shreya");
        obj.setDob(LocalDate.of(2002,03,02));
        obj.setSalary(45000);
        em.persist(obj);
        em.getTransaction().commit();
    }
}
