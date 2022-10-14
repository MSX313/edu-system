package org.msx.software.edu.system.business.common.enums.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EDUCourseType {

    THEORETICAL("THEORETICAL", "نظری"),
    PRACTICAL("PRACTICAL", "عملی"),
    LABORATORY("LABORATORY", "آزمایشگاهی");

    private final String code;
    private final String value;
}