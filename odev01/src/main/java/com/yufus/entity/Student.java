package com.yufus.entity;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER)
    private  Department department;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private  Lesson lesson;

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

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
