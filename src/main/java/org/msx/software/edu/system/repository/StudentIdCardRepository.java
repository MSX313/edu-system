package org.msx.software.edu.system.repository;

import org.msx.software.edu.system.model.entity.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentIdCardRepository
        extends JpaRepository<StudentIdCard, Long> {
}