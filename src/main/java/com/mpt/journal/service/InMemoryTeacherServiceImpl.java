package com.mpt.journal.service;
import com.mpt.journal.entity.TeacherEntity;
import com.mpt.journal.model.TeacherModel;
import com.mpt.journal.repository.InMemoryTeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryTeacherServiceImpl implements TeacherService {

    private final InMemoryTeacherRepository teacherRepository;

    public InMemoryTeacherServiceImpl(InMemoryTeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherModel> findAllTeachers() {
        return teacherRepository.findAllTeachers();
    }

    @Override
    public TeacherModel findTeacherById(int id) {
        return teacherRepository.findTeacherById(id);
    }

    @Override
    public TeacherModel addTeacher(TeacherModel teacher) {
        return teacherRepository.addTeacher(teacher);
    }

    @Override
    public TeacherModel updateTeacher(TeacherModel teacher) {
        return teacherRepository.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteTeacher(id);
    }
}

