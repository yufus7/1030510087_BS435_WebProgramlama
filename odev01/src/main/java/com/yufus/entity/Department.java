package com.yufus.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departmentName")
    private String departmentName;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Student student;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Lesson lesson;

    public  Department(){
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Student getStudent() {
        return student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
