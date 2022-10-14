package org.msx.software.edu.system.business.common.enums.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EDUCurrencyType {

    RIAL("RIAL", "ریال"),
    DOLLAR("DOLLAR", "دلار"),
    EURO("EURO", "یورو");

    private final String code;
    private final String value;
}