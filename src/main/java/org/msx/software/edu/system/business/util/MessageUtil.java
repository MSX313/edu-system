package org.msx.software.edu.system.business.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Locale;
import java.util.ResourceBundle;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageUtil {

    public static String format(String messageCode) {
        return format(messageCode, (Object[]) null);
    }

    public static String format(String messageCode, Object... params) {
        StringBuilder sb = new StringBuilder();
        String[] messageLines = messageCode.split("\n");
        ResourceBundle rb = ResourceBundle.getBundle(
                "ErrorMessages",
                new Locale("fa", "IR"),
                new CustomResourceBundleControl()
        );
        for (String messageLine : messageLines) {
            try {
                if (params != null) {
                    sb.append(String.format(rb.getString(messageLine), params));
                } else {
                    sb.append(rb.getString(messageLine));
                }
            } catch (RuntimeException ex) {
                sb.append(messageCode);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}