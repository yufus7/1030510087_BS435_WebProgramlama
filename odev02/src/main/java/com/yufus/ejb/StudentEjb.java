package com.yufus.ejb;

import com.yufus.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

public class StudentEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentEjb(){}

    public void registerNewStudent(Long id, String studentName, String studentSurname, Integer studentClass){
        if(isRegistered(id)){
            return;
        }

        Student student = new Student();
        student.setStudentName(studentName);
        student.setStudentSurname(studentSurname);
        student.setStudentClass(studentClass);

        entityManager.persist(student);
    }

    public boolean isRegistered(@NotNull Long id){
    Student student = entityManager.find(Student.class, id);
    return student != null;
    }

    public long getNumberOfStudents(){
        TypedQuery<Long> query = entityManager.createQuery("select count(s) from Student s", Long.class);
        long n = query.getSingleResult();
        return n;
    }
}
