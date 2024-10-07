package com.mpt.journal.repository;

import com.mpt.journal.model.CourseModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Repository
public class InMemoryCourseRepository {
    private List<CourseModel> courses = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public CourseModel addCourse(CourseModel course) {
        course.setId(idCounter.getAndIncrement());
        courses.add(course);
        return course;
    }

    public CourseModel updateCourse(CourseModel course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == course.getId()) {
                courses.set(i, course);
                return course;
            }
        }
        return null;
    }

    public void deleteCourse(int id) {
        courses.removeIf(course -> course.getId() == id);
    }

    public List<CourseModel> findAllCourses() {
        return new ArrayList<>(courses);
    }

    public CourseModel findCourseById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

