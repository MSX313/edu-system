package org.msx.software.edu.system.model.repository;


import org.msx.software.edu.system.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Transactional(readOnly = true)
    Optional<UserEntity> findByUserName(String username);
}