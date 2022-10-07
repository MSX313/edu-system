package org.msx.software.edu.system.business.common.enums;

public enum EDUContactInformationType {

    PHONE_NUMBER("PHONE_NUMBER", "شماره تلفن"),
    MOBILE_NUMBER("MOBILE_NUMBER", "شماره موبایل"),
    SKYPE("SKYPE", "اسکایپ"),
    EMAIL("EMAIL", "ایمیل"),
    ADDRESS("ADDRESS", "محل سکونت");

    private final String code;
    private final String value;

    EDUContactInformationType(String code, String value) {
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