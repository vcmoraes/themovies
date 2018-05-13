package br.com.victormoraes.core.util;

public class ImageUtil {

    public static String getUrlImageW500(String path) {
        return "https://image.tmdb.org/t/p/w500/" + path;
    }

    public static String getUrlImageOriginal(String path) {
        return "https://image.tmdb.org/t/p/original/" + path;
    }
}
