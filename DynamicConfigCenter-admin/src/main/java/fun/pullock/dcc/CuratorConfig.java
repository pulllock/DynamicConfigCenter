package fun.pullock.dcc;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CuratorConfig {

    @Value("${curator.connectString}")
    private String connectString;

    @Value("${curator.sessionTimeoutMs}")
    private int sessionTimeoutMs;

    @Value("${curator.connectionTimeoutMs}")
    private int connectionTimeoutMs;

    @Value("${curator.retryTimes}")
    private int retryTimes;

    @Value("${curator.sleepMsBetweenRetries}")
    private int sleepMsBetweenRetries;

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory
            .builder()
            .connectString(connectString)
            .sessionTimeoutMs(sessionTimeoutMs)
            .connectionTimeoutMs(connectionTimeoutMs)
            .retryPolicy(new RetryNTimes(retryTimes, sleepMsBetweenRetries))
            .build()
            ;
    }

}
