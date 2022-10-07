package org.msx.software.edu.system.service.category;


import org.msx.software.edu.system.model.entity.Category;

public interface CategoryBusiness {

    Category findByCode(String code);

    void save(Category category);
}