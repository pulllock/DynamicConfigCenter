package me.cxis.dcc.loader;

public abstract class AbstractConfigLoader implements ConfigLoader {

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
}
