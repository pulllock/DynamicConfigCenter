package me.cxis.dcc.loader;

import me.cxis.dcc.listener.ConfigListener;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConfigLoader implements ConfigLoader {

    protected List<ConfigListener> configListeners = new ArrayList<>();

    public AbstractConfigLoader() {
        init();
    }

    protected abstract void init();

    @Override
    public String get(String key) {
        String realKey = parseKey(key);
        return doGet(realKey);
    }

    protected abstract String doGet(String key);

    @Override
    public void addConfigListener(ConfigListener configListener) {
        configListeners.add(configListener);
    }
}
