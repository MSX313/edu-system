package org.msx.software.edu.system.mapper;


import org.msx.software.edu.system.common.enums.EDUCurrencyType;
import org.msx.software.edu.system.mapper.util.CategoryElementVmMapper;

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