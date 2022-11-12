package com.yufus.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departmentName")
    private String departmentName;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    public  Department(){
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
