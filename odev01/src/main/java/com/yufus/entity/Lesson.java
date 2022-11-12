package com.yufus.entity;

import javax.persistence.*;

@Entity
@Table(name="lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lessonName")
    private String lessonName;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.EAGER)
    private Student student;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.EAGER)
    private Department department;

    public Lesson() {
    }

    public Long getId() {
        return id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public Student getStudent() {
        return student;
    }

    public Department getDepartment() {
        return department;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
