package org.msx.software.edu.system.repository;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.msx.software.edu.system.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

}