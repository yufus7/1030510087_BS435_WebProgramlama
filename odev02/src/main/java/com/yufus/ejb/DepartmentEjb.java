package com.yufus.ejb;


import com.yufus.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

public class DepartmentEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public DepartmentEjb(){}

    public void registerNewDepartment(Long id, String departmentName){
        if(isRegistered(id)){
            return;
        }

        Department department = new Department();
        department.setDepartmentName(departmentName);

        entityManager.persist(department);
    }

    public boolean isRegistered(@NotNull Long id){
        Department department = entityManager.find(Department.class, id);
        return department != null;
    }

    public long getNumberOfDepartments(){
        TypedQuery<Long> query = entityManager.createQuery("select count(s) from Department s", Long.class);
        long n = query.getSingleResult();
        return n;
    }
}
