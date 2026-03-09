package org.example;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.util.List;

public class CriteriaDemo {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<EmployeeTable> root = cq.from(EmployeeTable.class);

        cq.multiselect(
                root.get("dept"),
                cb.count(root)
        );

        cq.groupBy(root.get("dept"));

        TypedQuery<Object[]> typedQuery = em.createQuery(cq);

        List<Object[]> results = typedQuery.getResultList();

        for (Object[] o : results) {
            System.out.println(o[0] + "\t" + o[1]);
        }

        em.close();
        emf.close();
    }
}