package com.yufus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lessonName")
    private String lessonName;

    @ManyToMany(mappedBy = "lesson")
    private List<Student> students;

    @ManyToOne
    private Department department;

    public Lesson() {
    }

    public Long getId() {
        return id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Department getDepartment() {
        return department;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
