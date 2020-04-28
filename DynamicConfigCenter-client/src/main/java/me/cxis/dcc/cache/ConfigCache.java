package me.cxis.dcc.cache;

import me.cxis.dcc.loader.ConfigLoaderDelegate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConfigCache {

    private static volatile ConfigCache configCache;

    private static ConcurrentMap<String, String> cachedConfigs = new ConcurrentHashMap<>();

    private static ConfigLoaderDelegate configLoaderDelegate = ConfigLoaderDelegate.getInstance();

    private ConfigCache() {

    }

    public static ConfigCache getInstance() {
        if (configCache == null) {
            synchronized (ConfigCache.class) {
                if (configCache == null) {
                    configCache = new ConfigCache();
                }
            }
        }
        return configCache;
    }

    public String get(String key) {
        String value = cachedConfigs.get(key);
        if (value == null) {
            value = configLoaderDelegate.get(key);
            cachedConfigs.put(key, value == null ? "" : value);
        }
        return value;
    }
}
