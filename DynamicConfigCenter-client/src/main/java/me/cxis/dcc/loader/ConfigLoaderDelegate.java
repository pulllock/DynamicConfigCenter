package me.cxis.dcc.loader;

public class ConfigLoaderDelegate {

    private ConfigLoader configLoader;

    private static volatile ConfigLoaderDelegate configLoaderDelegate;

    private ConfigLoaderDelegate() {

    }

    private ConfigLoaderDelegate(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    public static ConfigLoaderDelegate getInstance() {
        return getInstance(new ZookeeperConfigLoader());
    }

    public static ConfigLoaderDelegate getInstance(ConfigLoader configLoader) {
        if (configLoaderDelegate == null) {
            synchronized (ConfigLoaderDelegate.class) {
                if (configLoaderDelegate == null) {
                    configLoaderDelegate = new ConfigLoaderDelegate(configLoader);
                }
            }
        }
        return configLoaderDelegate;
    }

    /**
     * 根据key获取value
     * @param key ${projectName}.key
     * @return
     */
    public String get(String key) {
        return configLoader.get(key);
    }
}
