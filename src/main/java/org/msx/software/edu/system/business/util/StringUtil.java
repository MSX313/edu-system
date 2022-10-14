package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    public static String unsignedString(String text) {
        text = SpecialCharacterFilter.remove(text);
        text = PersianCharacterReplacement.replace(text);
        text = PersianCharacterReplacement.replaceCharForUnsigned(text);
        text = DigitsReplacement.replace(text);
        return text.toLowerCase();
    }

    public static Set<String> splitSearchValue(String searchValue) {
        String[] keys = searchValue.split("[\\u0020\\u200c]");
        Set<String> result = new HashSet<>();
        for (String key : keys) {
            if (!SearchIgnoreWord.isIgnored(key)) {
                result.add(StringUtil.unsignedString(key));
            }
        }
        return result;
    }
}