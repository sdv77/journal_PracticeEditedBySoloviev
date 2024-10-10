package com.mpt.journal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email(message = "Некорректный email")
    @NotBlank(message = "Email не должен быть пустым")
    private String email;

    @ManyToOne
    @JoinColumn(name = "courses_id") // Укажите имя столбца в таблице студентов
    private Courses courses;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @Email(message = "Некорректный email") @NotBlank(message = "Email не должен быть пустым") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Некорректный email") @NotBlank(message = "Email не должен быть пустым") String email) {
        this.email = email;
    }

    public Courses getCourses() {
        return courses;
    }


    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
