package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpecialCharacterFilter {

    public static String remove(String text) {
        String[] specialChars = {
                "\\u0652", "\\u064c", "\\u064d", "\\u064b", "\\u064f", "\\u0650", "\\u064e",
                "\\u0651", "\\u200c", "\\u0020", "\\u00ab", "\\u00bb", "\\u003c", "\\u003e",
                "\\u0653", "\\u0670", "\\u005c", "\\u002d", "\\u002b", "\\u007e", "\\u0060",
                "\\u0027", "\\u0022", "\\u0021", "\\u0040", "\\u0023", "\\u066c", "\\u066b",
                "\\u00f7", "\\u0024", "\\u0025", "\\u005e", "\\u0026", "\\u002a", "\\u0028",
                "\\u0029", "\\u005f", "\\u007d", "\\u007b", "\\u005d", "\\u005b", "\\u002e",
                "\\u060c", "\\u002c", "\\u002f"};
        StringBuilder patternString = new StringBuilder();
        stream(specialChars).forEach(patternString::append);
        Pattern pattern = Pattern.compile("[" + patternString + "]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String str = matcher.group();
            StringBuilder hex = new StringBuilder(Integer.toHexString(str.toCharArray()[0]));
            int length = hex.length();
            for (int i = 0; i < 4 - length; i++) {
                hex.insert(0, "0");
            }
            hex.insert(0, "\\u");
            text = text.replaceFirst(hex.toString(), "");
        }
        return text;
    }
}