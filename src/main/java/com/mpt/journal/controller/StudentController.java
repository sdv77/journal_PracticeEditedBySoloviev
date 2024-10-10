package com.mpt.journal.controller;

import com.mpt.journal.model.Courses;
import com.mpt.journal.model.StudentModel;
import com.mpt.journal.service.CourseService;
import com.mpt.journal.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Основная бизнес-логика нашего проекта
@Controller
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService coursesService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<StudentModel> students = studentService.findAllStudent();
        List<Courses> courses = coursesService.findAllCourses(); // Получите все оценки

        model.addAttribute("students", students);
        model.addAttribute("courses", courses); // Передайте оценки в модель
        model.addAttribute("student", new StudentModel()); // Передайте новый объект студента

        return "students"; // Вернуть имя шаблона
    }

    @GetMapping("/student/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new StudentModel()); // Передаем новый объект студента
        return "createStudent"; // возвращаем имя шаблона
    }


    @PostMapping("/students")
    public String createStudent(@Valid @ModelAttribute StudentModel student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<StudentModel> students = studentService.findAllStudent();
            List<Courses> courses = coursesService.findAllCourses(); // Получите все оценки

            model.addAttribute("students", students);
            model.addAttribute("courses", courses); // Передайте оценки в модель
            model.addAttribute("student", new StudentModel()); // Передайте новый объект студента

            return "students";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }



    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        StudentModel student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/students/update")
    public String updateStudent(@Valid @ModelAttribute StudentModel student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<StudentModel> students = studentService.findAllStudent();
            model.addAttribute("students", students);
            model.addAttribute("student", student);
            return "students";
        }
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
