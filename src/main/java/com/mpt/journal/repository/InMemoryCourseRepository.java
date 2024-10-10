//package com.mpt.journal.repository;
//
//import com.mpt.journal.model.Courses;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
//@Repository
//public class InMemoryCourseRepository {
//    private List<Courses> courses = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(1);
//
//    public List<Courses> findByCourseName(String courseName) {
//        return courses.stream()
//                .filter(course -> course.getCourseName().equalsIgnoreCase(courseName) && !course.isDeleted())
//                .collect(Collectors.toList());
//    }
//
//    public List<Courses> filterCourses(String courseName, Boolean deleted, Integer id) {
//        return courses.stream()
//                .filter(course -> (courseName == null || course.getCourseName().equalsIgnoreCase(courseName)) &&
//                        (deleted == null || course.isDeleted() == deleted) &&
//                        (id == null || course.getId() == id))
//                .collect(Collectors.toList());
//    }
//
//    public void logicalDeleteCourse(int id) {
//        courses.stream()
//                .filter(course -> course.getId() == id)
//                .forEach(course -> course.setDeleted(true));
//    }
//
//    public void logicalDeleteCourses(List<Integer> ids) {
//        courses.stream()
//                .filter(course -> ids.contains(course.getId()))
//                .forEach(course -> course.setDeleted(true));
//    }
//
//    public void deleteCourse(int id) {
//        courses.removeIf(course -> course.getId() == id);
//    }
//
//
//    public Courses addCourse(Courses course) {
//        course.setId(idCounter.getAndIncrement());
//        courses.add(course);
//        return course;
//    }
//
//    public Courses updateCourse(Courses course) {
//        for (int i = 0; i < courses.size(); i++) {
//            if (courses.get(i).getId() == course.getId()) {
//                courses.set(i, course);
//                return course;
//            }
//        }
//        return null;
//    }
//
//
//    public List<Courses> findAllCourses() {
//        return new ArrayList<>(courses);
//    }
//
//    public Courses findCourseById(int id) {
//        return courses.stream()
//                .filter(course -> course.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//}
//
