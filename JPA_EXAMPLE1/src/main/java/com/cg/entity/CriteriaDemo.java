package com.cg.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        EntityManager em=emf.createEntityManager();
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Product> cq=cb.createQuery(Product.class);
        Root<Product> r=cq.from(Product.class);
        Predicate condition1=cb.greaterThan(r.get("price"),6000);
        Predicate cond1=cb.greaterThan(r.get("price"),5000);
        Predicate cond2=cb.lessThan(r.get("price"),70000);
//        cq.select(r).where(condition1);
//        cq.select(r).where(cb.like(r.get("name"),"I%"));
//        cq.select(r).where(cb.and(cond1,cond2));
        cq.select(r).where(cb.and(cond1,cond2)).orderBy(cb.desc(r.get("name")));
      //  Root<Product> r=cq.from(Product.class);
        List<Product> li=em.createQuery(cq).getResultList();
        li.forEach(p-> System.out.println(p));
    }
}
