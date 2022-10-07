package org.msx.software.edu.system.business.common.enums;

public enum EDUUserType {

    LABOR("LABOR", "کارمند"),
    TEACHER("TEACHER", "استاد"),
    STUDENT("STUDENT", "دانشجو");

    private final String code;
    private final String value;

    EDUUserType(String code, String value) {
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
