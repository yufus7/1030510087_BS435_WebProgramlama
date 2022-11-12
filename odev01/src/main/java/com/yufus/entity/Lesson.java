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

    @ManyToMany(mappedBy = "lesson", fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToMany(mappedBy = "lesson", fetch = FetchType.EAGER)
    private List<Department> department;

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

    public List<Department> getDepartment() {
        return department;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

}
