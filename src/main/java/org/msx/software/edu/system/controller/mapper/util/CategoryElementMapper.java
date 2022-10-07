package org.msx.software.edu.system.controller.mapper.util;

import org.msx.software.edu.system.controller.vm.util.CategoryElementVm;

import java.util.List;

public interface CategoryElementMapper {

    List<CategoryElementVm> map(Class<?> enumClass);
}