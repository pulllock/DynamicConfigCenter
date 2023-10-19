package fun.pullock.dcc.loader;

import fun.pullock.dcc.listener.ConfigListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractConfigLoader implements ConfigLoader {

    protected List<ConfigListener> configListeners = new ArrayList<>();

    protected Map<String, ConfigListener> configListenerMap = new ConcurrentHashMap<>();

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

    @Override
    public void addConfigListener(String key, ConfigListener configListener) {
        configListenerMap.put(key, configListener);
    }
}
