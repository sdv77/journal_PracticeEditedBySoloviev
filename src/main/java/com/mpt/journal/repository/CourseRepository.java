package com.mpt.journal.repository;

import com.mpt.journal.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Long> {
}
