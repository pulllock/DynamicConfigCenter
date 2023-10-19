package fun.pullock.dcc;

import fun.pullock.dcc.listener.ConfigEvent;
import fun.pullock.dcc.listener.ConfigListener;
import org.junit.Test;

public class DCCTest {

    static String key = "TestProject.user.prefix";
    static String userPrefix;

    @Test
    public void testGet() {
        System.out.println(DCC.get("TestProject.user.prefix"));

       for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(DCC.get("TestProject.user.prefix"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGetListener() {
        userPrefix = DCC.get(key);

        DCC.addConfigListener(key, new ConfigListener() {
            @Override
            public void configUpdate(ConfigEvent configEvent) {
                System.out.println(String.format("ConfigEvent: %s", configEvent));
                userPrefix = configEvent.getValue();
            }
        });

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(userPrefix);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
