package com;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class DepartmentMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        Department department = new Department("IT");

        List<Employee> li = new ArrayList<>();
        li.add(new Employee("Shreya",department));
        li.add(new Employee("Siva",department));
        li.add(new Employee("Aasth",department));



        department.setEmp(li);
        em.persist(department);
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Done");



    }
}
