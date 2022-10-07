package org.msx.software.edu.system.business.common.enums;

public enum EDUGenderType {

    MAIL("MAIL", "مذکر"),
    FEMALE("FEMALE", "مونث"),
    TRANS("TRANS", "ترنس");

    private final String code;
    private final String value;

    EDUGenderType(String code, String value) {
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