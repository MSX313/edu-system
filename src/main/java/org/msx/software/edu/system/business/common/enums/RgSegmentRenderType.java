package org.msx.software.edu.system.business.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RgSegmentRenderType {

    TPTV("TPTV", "واژه ی مشخصه - واژه ی ارزش"),
    TPAV("TPAV", "واژه ی مشخصه - مخفف ارزش"),
    APTV("APTV", "مخفف مشخصه - واژه ی ارزش"),
    APAV("APAV", "مخفف مشخصه - مخفف ارزش"),
    TV("TV", "واژه ارزش"),
    AV("AV", "مخفف ارزش"),
    TP("TP", "واژه ی مشخصه"),
    AP("AP", "مخفف مشخصه");

    private final String code;
    private final String value;

    public final static String RG_SEGMENT_RENDER_TYPE_ALLOWABLE_VALUE =
            "TPTV | TPAV | APTV | APAV | TV | AV | TP | AP";
}