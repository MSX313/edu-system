package org.msx.software.edu.system.business.common.enums.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EDUUserType {

    LABOR("LABOR", "کارمند"),
    TEACHER("TEACHER", "استاد"),
    STUDENT("STUDENT", "دانشجو");

    private final String code;
    private final String value;
}