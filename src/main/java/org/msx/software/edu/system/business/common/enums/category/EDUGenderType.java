package org.msx.software.edu.system.business.common.enums.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EDUGenderType {

    MAIL("MAIL", "مذکر"),
    FEMALE("FEMALE", "مونث"),
    TRANS("TRANS", "ترنس");

    private final String code;
    private final String value;
}