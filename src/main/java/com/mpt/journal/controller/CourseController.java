//package com.mpt.journal.controller;
//import com.mpt.journal.model.CourseModel;
//import com.mpt.journal.service.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class CourseController {
//
//    @Autowired
//    private CourseService courseService;
//
//    @GetMapping("/courses")
//    public String getAllCourses(Model model) {
//        model.addAttribute("courses", courseService.findAllCourses());
//        return "courseList";
//    }
//
//    @PostMapping("/courses/add")
//    public String addCourse(@RequestParam String courseName) {
//        CourseModel newCourse = new CourseModel(0, courseName);
//        courseService.addCourse(newCourse);
//        return "redirect:/courses";
//    }
//
//    @PostMapping("/courses/update")
//    public String updateCourse(@RequestParam int id, @RequestParam String courseName) {
//        CourseModel updatedCourse = new CourseModel(id, courseName);
//        courseService.updateCourse(updatedCourse);
//        return "redirect:/courses";
//    }
//
//    @PostMapping("/courses/delete")
//    public String deleteCourse(@RequestParam int id) {
//        courseService.deleteCourse(id);
//        return "redirect:/courses";
//    }
//
//    @GetMapping("/courses/search")
//    public String searchCourses(@RequestParam String courseName, Model model) {
//        model.addAttribute("courses", courseService.findByCourseName(courseName));
//        return "courseList";
//    }
//
//    @GetMapping("/courses/filter")
//    public String filterCourses(@RequestParam(required = false) String courseName,
//                                @RequestParam(required = false) Boolean deleted,
//                                @RequestParam(required = false) Integer id,
//                                Model model) {
//        model.addAttribute("courses", courseService.filterCourses(courseName, deleted, id));
//        return "courseList";
//    }
//
//    @PostMapping("/courses/deleteMultiple")
//    public String deleteMultipleCourses(@RequestParam List<Integer> ids) {
//        courseService.logicalDeleteCourses(ids);
//        return "redirect:/courses";
//    }
//
//    @PostMapping("/courses/delete/logical")
//    public String logicalDeleteCourse(@RequestParam int id) {
//        courseService.logicalDeleteCourse(id);
//        return "redirect:/courses";
//    }
//
//    @PostMapping("/courses/deletePermanent")
//    public String deletePermanentCourse(@RequestParam int id) {
//        courseService.deleteCourse(id);
//        return "redirect:/courses";
//    }
//}
