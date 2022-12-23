package com.yufus.ejb;


import com.yufus.entity.Department;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class DepartmentEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public DepartmentEjb(){}

    public void registerNewDepartment(String departmentName){
        Department department = new Department();
        department.setDepartmentName(departmentName);

        entityManager.persist(department);
    }

    public Department getDepartmentById(long departmentId){
        Department department = entityManager.find(Department.class,departmentId);
        return department;
    }


    public long getNumberOfDepartments(){
        TypedQuery<Long> query = entityManager.createQuery("select count(s) from Department s", Long.class);
        long n = query.getSingleResult();
        return n;
    }
}
