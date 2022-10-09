package org.msx.software.edu.system.model.repository;

import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseHealthCheckRepository extends JpaRepository<BaseEntity, Long> {

    @Query(value = "SELECT 1 FROM dual", nativeQuery = true)
    Long checkDatabase();
}
