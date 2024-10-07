package com.mpt.journal.repository;

import org.springframework.stereotype.Repository;
import com.mpt.journal.model.TeacherModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Repository
public class InMemoryTeacherRepository {
    private List<TeacherModel> teachers = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public TeacherModel addTeacher(TeacherModel teacher) {
        teacher.setId(idCounter.getAndIncrement());
        teachers.add(teacher);
        return teacher;
    }

    public TeacherModel updateTeacher(TeacherModel teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == teacher.getId()) {
                teachers.set(i, teacher);
                return teacher;
            }
        }
        return null;
    }

    public void deleteTeacher(int id) {
        teachers.removeIf(teacher -> teacher.getId() == id);
    }

    public List<TeacherModel> findAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public TeacherModel findTeacherById(int id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

