package com.cg.entity;

import jakarta.persistence.*;

import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        EntityManager em=emf.createEntityManager();

//        TypedQuery<Product> q=em.createQuery("from Product",Product.class);
 //       TypedQuery<String> q=em.createQuery("select p.name from Product p",String.class);
//        List<String> li=q.getResultList();

//        List<Product> li=q.getResultList();
 //       li.forEach(p-> System.out.println(p));
        TypedQuery<ProductDto> q=em.createQuery("select new ProductDto(p.name,p.price,p.mfd) from Product p",ProductDto.class);
        List<ProductDto>li=q.getResultList();
        li.forEach(p-> System.out.println(p));

//        TypedQuery<Product> p1=em.createQuery("select p from product p where p.name like :p", Product.class);
//        p1.getParameter("p","L%");
//        List<Product>l1= p1.getResultList();
//        li.forEach(p-> System.out.println(p));

        em.getTransaction().begin();
        Query qry = em.createQuery(
                "update Product p set p.price = 6500 where p.id = 102"
        );
        int row = qry.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Updated -> " + row);

//================================================CREATE NATIVE QUERY===================================================
        em.getTransaction().begin();
        Query q2 = em.createNativeQuery(
                "update product_table p set p.price = 55000 where p.pid = 103"
        );
        int row2 = q2.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Updated -> " + row2);
    }
}
