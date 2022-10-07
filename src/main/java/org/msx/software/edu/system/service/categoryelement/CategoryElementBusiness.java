package org.msx.software.edu.system.service.categoryelement;

import org.msx.software.edu.system.exception.CommonException;
import org.msx.software.edu.system.model.entity.CategoryElement;

import java.util.Set;

public interface CategoryElementBusiness {

    CategoryElement findByCode(String code);

    Boolean isCodeExistInEnum(String code, Class<?> enumClass) throws CommonException;

    Set<CategoryElement> getByEnumCode(String enumClass);
}