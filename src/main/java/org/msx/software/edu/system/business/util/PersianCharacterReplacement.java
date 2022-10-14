package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersianCharacterReplacement {

    private static final char CHAR_ONE = 'ي';
    private static final char CHAR_TWO = 'ك';
    private static final char CHAR_THREE = 'ؤ';
    private static final char CHAR_FOUR = 'ئ';
    private static final char CHAR_FIVE = 'إ';
    private static final char CHAR_SIX = 'أ';
    private static final char CHAR_SEVEN = 'ة';
    private static final char CHAR_EIGHT = 'آ';
    private static final char CHAR_NINE = 'ء';
    private static final char CHAR_ONE_REPLACEMENT = 'ی';
    private static final char CHAR_TWO_REPLACEMENT = 'ک';
    private static final char CHAR_THREE_REPLACEMENT = 'و';
    private static final char CHAR_FOUR_REPLACEMENT = 'ی';
    private static final char CHAR_FIVE_REPLACEMENT = 'ا';
    private static final char CHAR_SIX_REPLACEMENT = 'ا';
    private static final char CHAR_SEVEN_REPLACEMENT = 'ه';
    private static final char CHAR_EIGHT_REPLACEMENT = 'ا';
    private static final char CHAR_NINE_REPLACEMENT = 'ی';

    public static String replace(String text) {
        text = text.replaceAll(String.valueOf(CHAR_ONE), String.valueOf(CHAR_ONE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(CHAR_TWO), String.valueOf(CHAR_TWO_REPLACEMENT));
        text = text.replaceAll(String.valueOf(CHAR_THREE), String.valueOf(CHAR_THREE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(CHAR_FOUR), String.valueOf(CHAR_FOUR_REPLACEMENT));
        text = text.replaceAll(String.valueOf(CHAR_FIVE), String.valueOf(CHAR_FIVE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(CHAR_SIX), String.valueOf(CHAR_SIX_REPLACEMENT));
        text = text.replaceAll(String.valueOf(CHAR_SEVEN), String.valueOf(CHAR_SEVEN_REPLACEMENT));
        text = text.replaceAll(String.valueOf(CHAR_NINE), String.valueOf(CHAR_NINE_REPLACEMENT));
        return text;
    }

    public static String replaceCharForUnsigned(String text) {
        return text.replaceAll(String.valueOf(CHAR_EIGHT), String.valueOf(CHAR_EIGHT_REPLACEMENT));
    }
}
