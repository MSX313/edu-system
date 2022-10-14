package org.msx.software.edu.system.controller.mapper;


import org.msx.software.edu.system.business.common.enums.category.EDUCourseType;
import org.msx.software.edu.system.controller.mapper.util.CategoryElementVmMapper;

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