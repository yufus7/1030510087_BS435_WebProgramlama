package com.yufus.ejb;

import com.yufus.entity.Advisor;
import com.yufus.entity.Department;
import com.yufus.entity.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class StudentEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentEjb(){}

    public void registerNewStudent(String studentName, String studentSurname, Integer studentClass, Long advisorId, Long departmentId){
        AdvisorEjb advisorEjb = new AdvisorEjb();
        Advisor advisor = advisorEjb.getAdvisorById(advisorId);

        DepartmentEjb departmentEjb = new DepartmentEjb();
        Department department = departmentEjb.getDepartmentById(departmentId);

        Student student = new Student();
        student.setStudentName(studentName);
        student.setStudentSurname(studentSurname);
        student.setStudentClass(studentClass);
        student.setAdvisor(advisor);
        student.setDepartment(department);

        entityManager.persist(student);
    }

    public Student getStudentById(long studentId){
        Student student = entityManager.find(Student.class,studentId);
        return student;
    }

    public long getNumberOfStudents(){
        TypedQuery<Long> query = entityManager.createQuery("select count(s) from Student s", Long.class);
        long n = query.getSingleResult();
        return n;
    }
}
