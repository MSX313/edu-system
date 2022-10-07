package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.model.entity.CategoryElement;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.controller.vm.util.CategoryElementVm;
import org.msx.software.edu.system.business.operation.EntityFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CategoryElementMapper extends BaseMapper<CategoryElement, CategoryElementVm> {

    @Autowired
    public CategoryElementMapper(@Qualifier("userFinderImpl") EntityFinder<UserEntity> userFinder) {
        super(userFinder);
    }

    @Override
    public void map(CategoryElement categoryElement, CategoryElementVm categoryElementVm) {
        super.map(categoryElement, categoryElementVm);
        categoryElementVm.setCode(categoryElement.getCode());
        categoryElementVm.setValue(categoryElement.getValue());
    }
}