package me.cxis.dcc.sample.dcc;

import me.cxis.dcc.DCC;
import me.cxis.dcc.listener.ConfigEvent;
import me.cxis.dcc.listener.ConfigListener;

public class DccConfig {

    private static final String TEST_PROJECT_USER_PREFIX = "TestProject.user.prefix";

    public static String userPrefix;

    static {
        userPrefix = DCC.get(TEST_PROJECT_USER_PREFIX);

        DCC.addConfigListener(TEST_PROJECT_USER_PREFIX, new ConfigListener() {
            @Override
            public void configUpdate(ConfigEvent configEvent) {
                userPrefix = configEvent.getValue();
            }
        });
    }
}
