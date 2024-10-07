package com.mpt.journal.service;


import com.mpt.journal.model.CourseModel;

import java.util.List;

public interface CourseService {
    public List<CourseModel> findAllCourses();
    public CourseModel findCourseById(int id);
    public CourseModel addCourse(CourseModel course);
    public CourseModel updateCourse(CourseModel course);
    public void deleteCourse(int id);
}
