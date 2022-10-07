package org.msx.software.edu.system.repository;

import org.msx.software.edu.system.model.entity.CategoryElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryElementRepository extends JpaRepository<CategoryElement, Long> {

    CategoryElement findByCode(String code);

    @Transactional(readOnly = true)
    Optional<CategoryElement> findByCodeAndCategory_Code(String code, String categoryCode);

    @Transactional(readOnly = true)
    List<CategoryElement> findAllByCategoryCode(String categoryCode);
}