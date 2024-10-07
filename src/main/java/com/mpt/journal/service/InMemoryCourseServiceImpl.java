package com.mpt.journal.service;
import com.mpt.journal.entity.CourseEntity;
import com.mpt.journal.model.CourseModel;
import com.mpt.journal.repository.InMemoryCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryCourseServiceImpl implements CourseService {

    private final InMemoryCourseRepository courseRepository;

    public InMemoryCourseServiceImpl(InMemoryCourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseModel> findAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public CourseModel findCourseById(int id) {
        return courseRepository.findCourseById(id);
    }

    @Override
    public CourseModel addCourse(CourseModel course) {
        return courseRepository.addCourse(course);
    }

    @Override
    public CourseModel updateCourse(CourseModel course) {
        return courseRepository.updateCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteCourse(id);
    }



    @Override
    public void logicalDeleteCourse(int id) {
        courseRepository.logicalDeleteCourse(id); // Логическое удаление
    }

    @Override
    public List<CourseModel> findByCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName); // Поиск
    }

    @Override
    public List<CourseModel> filterCourses(String courseName, Boolean deleted, Integer id) {
        return courseRepository.filterCourses(courseName, deleted, id); // Фильтрация
    }

    @Override
    public void logicalDeleteCourses(List<Integer> ids) {
        courseRepository.logicalDeleteCourses(ids); // Множественное логическое удаление
    }
}

