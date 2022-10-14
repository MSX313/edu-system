package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublicUniqueCodeGenerator {

    public static String generate(long id, String irdi) {
        return String.format("%s:%s", id, irdi.replace('#', ':'));
    }
}
