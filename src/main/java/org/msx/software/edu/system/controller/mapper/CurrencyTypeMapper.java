package org.msx.software.edu.system.controller.mapper;


import org.msx.software.edu.system.business.common.enums.category.EDUCurrencyType;
import org.msx.software.edu.system.controller.mapper.util.CategoryElementVmMapper;

class CurrencyTypeMapper extends CategoryElementVmMapper<EDUCurrencyType> {

    @Override
    protected String getCode(EDUCurrencyType enumeration) {
        return enumeration.getCode();
    }

    @Override
    protected String getValue(EDUCurrencyType enumeration) {
        return enumeration.getValue();
    }
}