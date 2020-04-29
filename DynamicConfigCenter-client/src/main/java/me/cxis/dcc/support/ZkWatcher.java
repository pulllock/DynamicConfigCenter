package me.cxis.dcc.support;

import me.cxis.dcc.loader.ZookeeperConfigLoader;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.zookeeper.WatchedEvent;

import static me.cxis.dcc.support.Constants.ROOT_PATH;
import static org.apache.zookeeper.Watcher.Event.EventType.NodeCreated;
import static org.apache.zookeeper.Watcher.Event.EventType.NodeDataChanged;

public class ZkWatcher implements CuratorListener {

    private ZookeeperConfigLoader zookeeperConfigLoader;

    public ZkWatcher(ZookeeperConfigLoader zookeeperConfigLoader) {
        this.zookeeperConfigLoader = zookeeperConfigLoader;
    }

    @Override
    public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
        System.out.println("监听，event: " + event);
        if (event.getType() == CuratorEventType.WATCHED) {
            WatchedEvent watchedEvent = event.getWatchedEvent();
            String path = watchedEvent.getPath();
            if (StringUtils.isNoneBlank(path) && path.startsWith(ROOT_PATH)) {
                String key = path.substring(ROOT_PATH.length() + 1).replace("/", ".");

                if (watchedEvent.getType() == NodeCreated || watchedEvent.getType() == NodeDataChanged) {
                    // 数据有变化，获取新数据，通知有变更，可以通知缓存和监听器
                    String value = zookeeperConfigLoader.get(key);
                    zookeeperConfigLoader.configUpdate(key, value);
                }
            }
        }
    }
}
