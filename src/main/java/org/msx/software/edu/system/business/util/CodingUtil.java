package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.msx.software.edu.system.business.common.codes.ExceptionMessageCode;
import org.msx.software.edu.system.business.dto.UniqueCodeDto;
import org.msx.software.edu.system.business.exception.ProcessException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodingUtil {

    public static UniqueCodeDto extractInputCode(String code) {
        String[] split = code.split(":");
        return new UniqueCodeDto(code, Long.parseLong(split[0]), split[1], Integer.parseInt(split[2]));
    }

    public static String mixIrdiCodePart(String uniqueCode, long version) {
        return String.format("%s#%s", uniqueCode, version);
    }

    public static String extractUniqueCodePart(String irdi) {
        return splitCode(irdi)[0];
    }

    public static long extractVersionCodePart(String irdi) {
        String versionPart = splitCode(irdi)[1];
        try {
            return Long.parseLong(versionPart);
        } catch (NumberFormatException ex) {
            throw new ProcessException(ExceptionMessageCode.IRDI_CODE_FORMAT_INVALID, irdi);
        }
    }

    private static String[] splitCode(String irdi) {
        String[] codeParts = irdi.split("#");
        if (codeParts.length != 2) {
            throw new ProcessException(ExceptionMessageCode.IRDI_CODE_FORMAT_INVALID, irdi);
        } else {
            return codeParts;
        }
    }
}
