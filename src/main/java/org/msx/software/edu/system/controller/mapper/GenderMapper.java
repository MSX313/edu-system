package org.msx.software.edu.system.controller.mapper;

import org.msx.software.edu.system.business.common.enums.category.EDUGenderType;
import org.msx.software.edu.system.controller.mapper.util.CategoryElementVmMapper;

class GenderMapper extends CategoryElementVmMapper<EDUGenderType> {

    @Override
    protected String getCode(EDUGenderType enumeration) {
        return enumeration.getCode();
    }

    @Override
    protected String getValue(EDUGenderType enumeration) {
        return enumeration.getValue();
    }
}