package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DigitsReplacement {

    //persian numbers
    private static final char FARSI_ZERO = '۰';
    private static final char FARSI_ONE = '۱';
    private static final char FARSI_TWO = '۲';
    private static final char FARSI_THREE = '۳';
    private static final char FARSI_FOUR = '۴';
    private static final char FARSI_FIVE = '۵';
    private static final char FARSI_SIX = '۶';
    private static final char FARSI_SEVEN = '۷';
    private static final char FARSI_EIGHT = '۸';
    private static final char FARSI_NINE = '۹';
    //arabic numbers
    private static final char ARABIC_ZERO = '٠';
    private static final char ARABIC_ONE = '١';
    private static final char ARABIC_TWO = '٢';
    private static final char ARABIC_THREE = '٣';
    private static final char ARABIC_FOUR = '٤';
    private static final char ARABIC_FIVE = '٥';
    private static final char ARABIC_SIX = '٦';
    private static final char ARABIC_SEVEN = '٧';
    private static final char ARABIC_EIGHT = '٨';
    private static final char ARABIC_NINE = '٩';
    //english numbers
    private static final char ZERO_REPLACEMENT = '0';
    private static final char ONE_REPLACEMENT = '1';
    private static final char TWO_REPLACEMENT = '2';
    private static final char THREE_REPLACEMENT = '3';
    private static final char FOUR_REPLACEMENT = '4';
    private static final char FIVE_REPLACEMENT = '5';
    private static final char SIX_REPLACEMENT = '6';
    private static final char SEVEN_REPLACEMENT = '7';
    private static final char EIGHT_REPLACEMENT = '8';
    private static final char NINE_REPLACEMENT = '9';

    public static String replace(String text) {
        //replace persian numbers with english numbers
        text = text.replaceAll(String.valueOf(FARSI_ZERO), String.valueOf(ZERO_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_ONE), String.valueOf(ONE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_TWO), String.valueOf(TWO_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_THREE), String.valueOf(THREE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_FOUR), String.valueOf(FOUR_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_FIVE), String.valueOf(FIVE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_SIX), String.valueOf(SIX_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_SEVEN), String.valueOf(SEVEN_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_EIGHT), String.valueOf(EIGHT_REPLACEMENT));
        text = text.replaceAll(String.valueOf(FARSI_NINE), String.valueOf(NINE_REPLACEMENT));
        //replace arabic numbers with english numbers
        text = text.replaceAll(String.valueOf(ARABIC_ZERO), String.valueOf(ZERO_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_ONE), String.valueOf(ONE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_TWO), String.valueOf(TWO_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_THREE), String.valueOf(THREE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_FOUR), String.valueOf(FOUR_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_FIVE), String.valueOf(FIVE_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_SIX), String.valueOf(SIX_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_SEVEN), String.valueOf(SEVEN_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_EIGHT), String.valueOf(EIGHT_REPLACEMENT));
        text = text.replaceAll(String.valueOf(ARABIC_NINE), String.valueOf(NINE_REPLACEMENT));
        return text;
    }
}