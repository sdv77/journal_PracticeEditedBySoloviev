package com.mpt.journal.controller;

import com.mpt.journal.service.TeacherService;
import org.springframework.stereotype.Controller;
import com.mpt.journal.model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public String getAllTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAllTeachers());
        return "teacherList";
    }

    @PostMapping("/teachers/add")
    public String addTeacher(@RequestParam String name,
                             @RequestParam String lastName,
                             @RequestParam String firstName,
                             @RequestParam String middleName) {
        TeacherModel newTeacher = new TeacherModel(0, name, lastName, firstName, middleName);
        teacherService.addTeacher(newTeacher);
        return "redirect:/teachers";
    }

    @PostMapping("/teachers/update")
    public String updateTeacher(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String lastName,
                                @RequestParam String firstName,
                                @RequestParam String middleName) {
        TeacherModel updatedTeacher = new TeacherModel(id, name, lastName, firstName, middleName);
        teacherService.updateTeacher(updatedTeacher);
        return "redirect:/teachers";
    }

    @PostMapping("/teachers/delete")
    public String deleteTeacher(@RequestParam int id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }
}

