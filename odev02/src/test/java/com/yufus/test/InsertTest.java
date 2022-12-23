package com.yufus.test;

import com.yufus.entity.Advisor;
import com.yufus.entity.Department;
import com.yufus.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertTest {

    private EntityManagerFactory factory;
    private EntityManager em;

    @BeforeEach
    public void init() {
        //her bir test calismadan once BeforeEach calistirilir
        factory = Persistence.createEntityManagerFactory("Hibernate");
        em = factory.createEntityManager();
    }

    @AfterEach
    public void tearDown() {
        //her bir test calistiktan sonra BeforeEach calistirilir

        em.close();
        factory.close();
    }

    private boolean persistInATransaction(Object obj) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(obj);
            tx.commit();
        } catch (Exception e) {
            System.out.println("FAILED TRANSACTION: " + e.toString());
            tx.rollback();
            return false;
        }

        return true;
    }


    @Test
    public void insertStudent() {

        Student student =new Student();
        boolean persisted = persistInATransaction(student);
        assertTrue(persisted);

    }
    @Test
    public void insertDepartment() {

        Department department =new Department();
        boolean persisted = persistInATransaction(department);
        assertTrue(persisted);

    }

    @Test
    public void insertAdvisor() {

        Advisor advisor =new Advisor();
        boolean persisted = persistInATransaction(advisor);
        assertTrue(persisted);

    }


}
