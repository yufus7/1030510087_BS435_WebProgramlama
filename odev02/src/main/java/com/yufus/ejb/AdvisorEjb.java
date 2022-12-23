package com.yufus.ejb;


import com.yufus.entity.Advisor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

public class AdvisorEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public AdvisorEjb(){}

    public void registerNewAdvisor(Long id, String name){
        if(isRegistered(id)){
            return;
        }

        Advisor advisor = new Advisor();
        advisor.setName(name);

        entityManager.persist(advisor);
    }

    public boolean isRegistered(@NotNull Long id){
        Advisor advisor = entityManager.find(Advisor.class, id);
        return advisor != null;
    }

    public long getNumberOfAdvisors(){
        TypedQuery<Long> query = entityManager.createQuery("select count(s) from Advisor s", Long.class);
        long n = query.getSingleResult();
        return n;
    }
}
