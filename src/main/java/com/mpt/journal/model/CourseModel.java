package com.mpt.journal.model;

public class CourseModel {
    private int id;
    private String courseName;
    private boolean deleted;

    public CourseModel(int id, String courseName) {
        this.id = id;
        this.courseName = courseName;
        this.deleted = false;

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}
