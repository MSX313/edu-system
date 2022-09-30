package org.msx.software.edu.system.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtil {

    public static boolean isNullOrEmpty(String string) {
        boolean isNullOrEmpty = false;
        if (Boolean.TRUE.equals(string == null)) {
            isNullOrEmpty = true;
        } else if (string.trim().isEmpty()) {
            isNullOrEmpty = true;
        }
        return isNullOrEmpty;
    }
}