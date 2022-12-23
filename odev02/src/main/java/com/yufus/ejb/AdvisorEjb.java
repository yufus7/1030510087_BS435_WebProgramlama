package com.yufus.ejb;


import com.yufus.entity.Advisor;
import com.yufus.entity.Department;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

@Stateless
public class AdvisorEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public AdvisorEjb(){}

    public void registerNewAdvisor(String name){
        Advisor advisor = new Advisor();
        advisor.setName(name);

        entityManager.persist(advisor);
    }

    public Advisor getAdvisorById(long advisorId){
        Advisor advisor = entityManager.find(Advisor.class,advisorId);

        return advisor;
    }

    public long getNumberOfAdvisors(){
        TypedQuery<Long> query = entityManager.createQuery("select count(s) from Advisor s", Long.class);
        long n = query.getSingleResult();
        return n;
    }
}
