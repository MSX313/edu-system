package org.msx.software.edu.system.business.operation.categoryelement;

import org.msx.software.edu.system.business.exception.CommonException;
import org.msx.software.edu.system.model.entity.CategoryElement;

import java.util.Set;

public interface CategoryElementBusiness {

    CategoryElement findByCode(String code);

    Boolean isCodeExistInEnum(String code, Class<?> enumClass) throws CommonException;

    Set<CategoryElement> getByEnumCode(String enumClass);
}