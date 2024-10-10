package com.mpt.journal.service;

import com.mpt.journal.model.Courses;
import com.mpt.journal.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository repository) {
        this.courseRepository = repository;
    }

    @Override
    public List<Courses> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses createCourses(Courses courses) {
        return courseRepository.save(courses);
    }

    @Override
    public Courses updateCourses(Courses courses) {
        return courseRepository.save(courses);
    }

    @Override
    public Courses findCoursesbyId(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCourses(Long id) {
        courseRepository.deleteById(id);
    }
}
