package com.mpt.journal.service;


import com.mpt.journal.model.Courses;

import java.util.List;

public interface CourseService {
    List<Courses> findAllCourses();
    Courses createCourses(Courses courses);
    Courses updateCourses(Courses courses);
    Courses findCoursesbyId(Long id);
    void deleteCourses(Long id);
}
