package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.model.entity.CategoryElement;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.msx.software.edu.system.controller.vm.CategoryElementVm;
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
    public void map(CategoryElement from, CategoryElementVm to) {
        super.map(from, to);
        to.setCode(from.getCode());
        to.setValue(from.getValue());
    }
}