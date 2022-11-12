package com.yufus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "studentSurname")
    private String studentSurname;

    @Column(name = "studentClass")
    private Integer studentClass;

    @ManyToOne
    private  Department department;

    @ManyToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    public Student(){
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public Integer getStudentClass() {
        return studentClass;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
