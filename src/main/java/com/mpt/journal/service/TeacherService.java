package com.mpt.journal.service;

import com.mpt.journal.model.TeacherModel;

import java.util.List;

public interface TeacherService {
    public List<TeacherModel> findAllTeachers();
    public TeacherModel findTeacherById(int id);
    public TeacherModel addTeacher(TeacherModel teacher);
    public TeacherModel updateTeacher(TeacherModel teacher);
    public void deleteTeacher(int id);
}

