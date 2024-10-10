package com.mpt.journal.model;

import jakarta.persistence.*;

import java.util.Collection;


@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Collection<StudentModel> studentModels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return name;
    }

    public void setDescription(String description) {
        this.name = description;
    }

    public Collection<StudentModel> getStudentModels() {
        return studentModels;
    }

    public void setStudentModels(Collection<StudentModel> studentModels) {
        this.studentModels = studentModels;
    }
}
