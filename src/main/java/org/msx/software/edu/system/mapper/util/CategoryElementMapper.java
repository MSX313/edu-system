package org.msx.software.edu.system.mapper.util;

import org.msx.software.edu.system.model.view.CategoryElementVm;

import java.util.List;

public interface CategoryElementMapper {

    List<CategoryElementVm> map(Class<?> enumClass);
}