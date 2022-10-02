package org.msx.software.edu.system.mapper;


import org.msx.software.edu.system.common.enums.EDUCourseType;
import org.msx.software.edu.system.mapper.util.CategoryElementVmMapper;

class CourseTypeMapper extends CategoryElementVmMapper<EDUCourseType> {

    @Override
    protected String getCode(EDUCourseType enumeration) {
        return enumeration.getCode();
    }

    @Override
    protected String getValue(EDUCourseType enumeration) {
        return enumeration.getValue();
    }
}