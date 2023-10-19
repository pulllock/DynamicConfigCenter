package fun.pullock.dcc.support;


import org.junit.Test;

public class InitClientTest {

    @Test
    public void testInitClient() {
        System.out.println(InitClient.getAppName());
        System.out.println(InitClient.getZookeeperAddress());
        System.out.println(InitClient.getProperties());
    }
}
