package fun.pullock.dcc.cache;

import fun.pullock.dcc.listener.ConfigEvent;
import fun.pullock.dcc.listener.ConfigListener;
import fun.pullock.dcc.loader.ConfigLoaderDelegate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConfigCache implements ConfigListener {

    private static volatile ConfigCache configCache;

    private static ConcurrentMap<String, String> cachedConfigs = new ConcurrentHashMap<>();

    private static ConfigLoaderDelegate configLoaderDelegate = ConfigLoaderDelegate.getInstance();

    private ConfigCache() {
        configLoaderDelegate.addConfigListener(this);
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

    @Override
    public void configUpdate(ConfigEvent configEvent) {
        cachedConfigs.put(configEvent.getKey(), configEvent.getValue() == null ? "" : configEvent.getValue());
    }
}
