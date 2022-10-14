package org.msx.software.edu.system.business.util;

import org.msx.software.edu.system.business.common.enums.RgSegmentRenderType;

public class RgSegmentRenderTypeUtil {

    public static boolean isApOrTp(String renderTypeCode) {
        return renderTypeCode.equals(RgSegmentRenderType.AP.getCode()) ||
                renderTypeCode.equals(RgSegmentRenderType.TP.getCode());
    }
}