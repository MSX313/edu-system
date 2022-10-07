package org.msx.software.edu.system.service.category;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.model.entity.Category;
import org.msx.software.edu.system.repository.CategoryRepository;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CategoryBusinessImpl implements CategoryBusiness {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findByCode(String code) {
        final Category[] category = {null};
        categoryRepository.findByCode(code).ifPresent(foundedCategory -> category[0] = foundedCategory);
        return category[0];
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }
}