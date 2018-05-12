package br.com.victormoraes.themovie.util;

import android.text.TextUtils;

public class StringUtil {

    public static String fixString(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string.trim();
    }

    public static boolean isNullOrEmpty(String value) {
        return value != null && value.trim().isEmpty();
    }
}
