package fun.pullock.dcc;

import fun.pullock.dcc.cache.ConfigCache;
import fun.pullock.dcc.listener.ConfigListener;
import fun.pullock.dcc.loader.ConfigLoaderDelegate;

/**
 * 客户端直接使用的入口
 */
public class DCC {

    private static final ConfigCache CONFIG_CACHE = ConfigCache.getInstance();

    private static ConfigLoaderDelegate configLoaderDelegate = ConfigLoaderDelegate.getInstance();

    private DCC() {

    }

    public static String get(String key) {
        return CONFIG_CACHE.get(key);
    }

    public static String get(String key, String defaultValue) {
        String value = CONFIG_CACHE.get(key);
        return value == null ? defaultValue : value;
    }

    public static int getIntValue(String key) {
        String value = CONFIG_CACHE.get(key);
        return Integer.parseInt(value);
    }

    public static int getIntValue(String key, int defaultValue) {
        String value = CONFIG_CACHE.get(key);
        return value == null ? defaultValue : Integer.parseInt(value);
    }

    public static long getLongValue(String key) {
        String value = CONFIG_CACHE.get(key);
        return Long.parseLong(value);
    }

    public static long getIntValue(String key, long defaultValue) {
        String value = CONFIG_CACHE.get(key);
        return value == null ? defaultValue : Long.parseLong(value);
    }

    public static void addConfigListener(String key, ConfigListener configListener) {
        configLoaderDelegate.addConfigListener(key, configListener);
    }
}
