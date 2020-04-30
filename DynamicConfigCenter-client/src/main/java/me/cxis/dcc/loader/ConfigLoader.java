package me.cxis.dcc.loader;

import me.cxis.dcc.listener.ConfigListener;

/**
 * 配置加载器接口
 * 配置加载可能会从系统环境变量、属性文件、Zookeeper等等位置加载
 */
public interface ConfigLoader {

    String get(String key);

    String parseKey(String key);

    void addConfigListener(ConfigListener configListener);

    void addConfigListener(String key, ConfigListener configListener);
}
