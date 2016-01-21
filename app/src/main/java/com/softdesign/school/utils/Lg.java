package com.softdesign.school.utils;

import android.util.Log;

/**
 * логер исспользует различные уровни вывода логов: verbose, debug, info, error, warn, assert
 */
public class Lg {
    private static final int LOGCAT_BUFFER_SIZE = 3000;
    private static final String PREFIX = "HTC ";
    private static boolean isEnabled = false;

    public static int get_bufferSize() {
        return LOGCAT_BUFFER_SIZE;
    }

    public static String get_prefix() {
        return PREFIX;
    }

    public static boolean get_isEnabled() {
        return isEnabled;
    }

    public static void set_isEnabled(Boolean value) {
        isEnabled = value;
    }

    /** вывод лога в verbose-уровень */
    public static void v (String tag, String text){
        if (get_isEnabled()) {
            out(tag, text, "v");
        }
    }

    /** вывод лога в debug-уровень */
    public static void d (String tag, String text){
        if (get_isEnabled()) {
            out(tag, text, "d");
        }
    }

    /** вывод лога в info-уровень */
    public static void i (String tag, String text){
        if (get_isEnabled()) {
            out(tag, text, "i");
        }
    }

    /** вывод лога в error-уровень */
    public static void e (String tag, String text){
        if (get_isEnabled()) {
            out(tag, text, "e");
        }
    }

    /** вывод лога в warn-уровень */
    public static void w (String tag, String text){
        if (get_isEnabled()) {
            out(tag, text, "w");
        }
    }

    /** вывод лога в asset-уровень */
    public static void a (String tag, String text){
        if (get_isEnabled()) {
            out(tag, text, "a");
        }
    }

    /** вывод сообщения в логер с учетом размера буфера и выбранного уровня*/
    private static void out(String tag, String text, String mode) {
        if (text.length() > LOGCAT_BUFFER_SIZE){
            String s = text;
            while (s.length() > LOGCAT_BUFFER_SIZE){
                String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                s = s.substring(LOGCAT_BUFFER_SIZE);
                print(PREFIX + tag, s1, mode);
            }
            print(PREFIX + tag, s, mode);
        } else {
            print(PREFIX + tag, text, mode);
        }

    }

    /** разводка уровней логера для вывода содержимого буффера*/
    private static void print(String tag, String text, String mode)
    {
        switch (mode){
            case "v": Log.v(tag, text);
                break;
            case "d": Log.d(tag, text);
                break;
            case "i": Log.v(tag, text);
                break;
            case "e": Log.d(tag, text);
                break;
            case "w": Log.v(tag, text);
                break;
            case "a": Log.d(tag, text);
                break;
        }
    }
}
