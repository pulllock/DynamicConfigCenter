package me.cxis.dcc.support;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class InitClient {

    private static Properties properties;

    private static String zookeeperAddress;

    private static String appName;

    private final static String PROPERTIES_NAME = "dcc.properties";

    static {
        properties = loadPropertiesFromClasspath(PROPERTIES_NAME);
        if (properties == null) {
            throw new RuntimeException(PROPERTIES_NAME + " empty");
        }

        appName = properties.getProperty("dcc.app.name");
        zookeeperAddress = properties.getProperty("dcc.zookeeper.address");
    }

    private static Properties loadPropertiesFromClasspath(String propertiesName) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(propertiesName);
        if (url== null) {
            throw new RuntimeException(propertiesName + " not exist");
        }

        InputStream inputStream = null;
        try {
            inputStream = url.openStream();
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private InitClient() {
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        InitClient.properties = properties;
    }

    public static String getZookeeperAddress() {
        return zookeeperAddress;
    }

    public static String getAppName() {
        return appName;
    }

}
