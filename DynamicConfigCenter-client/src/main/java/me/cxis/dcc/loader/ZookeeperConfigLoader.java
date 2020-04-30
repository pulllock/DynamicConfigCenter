package me.cxis.dcc.loader;

import me.cxis.dcc.listener.ConfigEvent;
import me.cxis.dcc.listener.ConfigListener;
import me.cxis.dcc.support.InitClient;
import me.cxis.dcc.support.ZkWatcher;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;

import java.nio.charset.StandardCharsets;

import static me.cxis.dcc.support.Constants.PATH_SEPARATOR;
import static me.cxis.dcc.support.Constants.ROOT_PATH;

public class ZookeeperConfigLoader extends AbstractConfigLoader {

    private CuratorFramework curatorClient;

    @Override
    protected void init() {
        // 创建CuratorFramework
        curatorClient = CuratorFrameworkFactory
            .builder()
            .connectString(InitClient.getZookeeperAddress())
            .sessionTimeoutMs(60000)
            .connectionTimeoutMs(60000)
            .retryPolicy(new RetryNTimes(3, 1000))
            .build();

        // 连接状态监听
        curatorClient
            .getConnectionStateListenable()
            .addListener(new ConnectionStateListener() {
                @Override
                public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
                    System.out.println("连接状态监听，connectionState: " + connectionState);
                    if (connectionState == ConnectionState.RECONNECTED) {
                        // TODO
                    }
                }
            });

        // 监听变化，可以改用NodeCacheListener
        curatorClient
            .getCuratorListenable()
            .addListener(new ZkWatcher(this));

        curatorClient.start();
    }

    @Override
    protected String doGet(String key) {
        try {
            byte[] data = curatorClient.getData().watched().forPath(key);
            if (data != null) {
                return new String(data, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String parseKey(String key) {
        String appName = InitClient.getAppName();
        if (key.startsWith(appName)) {
            String prefix = appName + ".";
            key = key.substring(prefix.length());
        }
        return ROOT_PATH + PATH_SEPARATOR + appName + PATH_SEPARATOR + key;
    }

    public void configUpdate(String key, String value) {
        ConfigEvent configEvent = new ConfigEvent(key, value);
        configListeners.forEach(configListener -> configListener.configUpdate(configEvent));

        ConfigListener configListener = configListenerMap.get(key);
        if (configListener != null) {
            configListener.configUpdate(configEvent);
        }
    }
}
