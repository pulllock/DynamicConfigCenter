package fun.pullock.dcc.sample.dcc;

import fun.pullock.dcc.DCC;
import fun.pullock.dcc.listener.ConfigEvent;
import fun.pullock.dcc.listener.ConfigListener;

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
