package com.mpt.journal.model;

public class CourseModel {
    private int Id;
    private String CourseName;

    public CourseModel(int id, String courseName) {
        Id = id;
        CourseName = courseName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}
