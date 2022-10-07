package org.msx.software.edu.system.controller.mapper.util;


import org.msx.software.edu.system.controller.vm.util.CategoryElementVm;
import org.msx.software.edu.system.business.common.codes.MessageCodes;

import javax.inject.Named;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Named
public class CategoryElementMapperImpl implements CategoryElementMapper {

    @Override
    public List<CategoryElementVm> map(Class<?> enumClass) {
        List<CategoryElementVm> enumElements = new ArrayList<>();
        for (Object enumConstant : enumClass.getEnumConstants()) {
            CategoryElementVm categoryElementVm = new CategoryElementVm();
            try {
                categoryElementVm.setCode(enumConstant.getClass().getDeclaredMethod(
                        MessageCodes.CATEGORY_ELEMENT_CODE).invoke(enumConstant).toString());
                categoryElementVm.setValue(enumConstant.getClass().getDeclaredMethod(
                        MessageCodes.CATEGORY_ELEMENT_VALUE).invoke(enumConstant).toString());
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            enumElements.add(categoryElementVm);
        }
        return enumElements;
    }
}