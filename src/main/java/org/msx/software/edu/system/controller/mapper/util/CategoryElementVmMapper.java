package org.msx.software.edu.system.controller.mapper.util;


import org.msx.software.edu.system.controller.vm.util.CategoryElementVm;

public abstract class CategoryElementVmMapper<T> {

    public CategoryElementVm map(T enumeration) {
        CategoryElementVm categoryElementVM = new CategoryElementVm();
        categoryElementVM.setCode(getCode(enumeration));
        categoryElementVM.setValue(getValue(enumeration));
        return categoryElementVM;
    }

    protected abstract String getCode(T enumeration);

    protected abstract String getValue(T enumeration);
}