package org.msx.software.edu.system.model.repository;

import org.msx.software.edu.system.model.entity.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

    List<Enrolment> findByUserEntityId(Long userEntityId);

    List<Enrolment> findByCourseId(Long courseId);
}