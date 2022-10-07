package org.msx.software.edu.system.mapper;

import org.msx.software.edu.system.common.enums.EDUGenderType;
import org.msx.software.edu.system.mapper.util.CategoryElementVmMapper;

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