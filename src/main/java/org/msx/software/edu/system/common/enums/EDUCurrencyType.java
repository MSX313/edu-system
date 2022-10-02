package org.msx.software.edu.system.common.enums;

public enum EDUCurrencyType {

    RIAL("RIAL", "ریال"),
    DOLLAR("DOLLAR", "دلار"),
    EURO("EURO", "یورو");

    private final String code;
    private final String value;

    EDUCurrencyType(String code, String value) {
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