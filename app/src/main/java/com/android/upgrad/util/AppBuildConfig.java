package com.android.upgrad.util;


public class AppBuildConfig {
    private final static String BASE_URL = "https://api.github.com/";
    private final static String APP_LOG = "UpGrad";

    public static String logTag() {
        return APP_LOG;
    }

    public static String getBaseURL() {
        return BASE_URL;
    }
}
