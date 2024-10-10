package com.mpt.journal.repository;

import com.mpt.journal.model.Courses;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryCourse {
    private final List<Courses> COURSES = new ArrayList<>();

    public List<Courses> findAllCourses(Long id) {
        return COURSES;
    }

    public Courses findCoursesbyId(Long id) {
        return COURSES
                .stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Courses createCourses(Courses courses) {
        COURSES.add(courses);
        return courses;
    }

    public Courses updateCourses(Courses courses) {
        var studentIndex = IntStream.range(0, COURSES.size())
                .filter(index -> COURSES.get(index).getId().equals(courses.getId()))
                .findFirst()
                .orElse(-1);
        if (studentIndex == -1) {
            return null;
        }
        COURSES.set(studentIndex, courses);
        return courses;
    }

    public void deleteCourses(Long id) {
        var student = findAllCourses(id);
        if (student != null) {
            COURSES.remove(student);
        }
    }
}
