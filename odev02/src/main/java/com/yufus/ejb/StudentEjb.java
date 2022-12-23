package com.yufus.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudentEjb {

    @PersistenceContext
    private EntityManager entityManager;
}
