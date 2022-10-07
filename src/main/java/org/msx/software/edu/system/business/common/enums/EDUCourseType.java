package org.msx.software.edu.system.business.common.enums;

public enum EDUCourseType {

    THEORETICAL("THEORETICAL", "نظری"),
    PRACTICAL("PRACTICAL", "عملی"),
    LABORATORY("LABORATORY", "آزمایشگاهی");

    private final String code;
    private final String value;

    EDUCourseType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}