package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Arrays.stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchIgnoreWord {

    private static final String[] IGNORE_LIST = {
            "ی", "و", "از", "تا", "در", "بر", "برای", "که", "با", "بی", "بدون",
            "from", "to", "in", "of", "with", "without"
    };

    public static Boolean isIgnored(String value) {
        return stream(IGNORE_LIST).anyMatch(ignoreItem ->
                Boolean.TRUE.equals(StringUtil.unsignedString(value).equals(StringUtil.unsignedString(ignoreItem))));
    }
}