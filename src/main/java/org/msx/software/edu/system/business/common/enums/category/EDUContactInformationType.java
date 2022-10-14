package org.msx.software.edu.system.business.common.enums.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EDUContactInformationType {

    PHONE_NUMBER("PHONE_NUMBER", "شماره تلفن"),
    MOBILE_NUMBER("MOBILE_NUMBER", "شماره موبایل"),
    SKYPE("SKYPE", "اسکایپ"),
    EMAIL("EMAIL", "ایمیل"),
    ADDRESS("ADDRESS", "محل سکونت");

    private final String code;
    private final String value;
}