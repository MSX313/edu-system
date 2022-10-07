package org.msx.software.edu.system.model.repository;

import org.msx.software.edu.system.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course, Long> {
}