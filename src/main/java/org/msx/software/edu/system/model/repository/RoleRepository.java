package org.msx.software.edu.system.model.repository;

import org.msx.software.edu.system.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Transactional(readOnly = true)
    Set<RoleEntity> findAllByCodeIn(List<String> roles);
}