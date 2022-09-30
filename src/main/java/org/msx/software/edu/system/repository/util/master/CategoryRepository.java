package org.msx.software.edu.system.repository.util.master;

import org.msx.software.edu.system.model.entity.util.master.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCode(String code);
}