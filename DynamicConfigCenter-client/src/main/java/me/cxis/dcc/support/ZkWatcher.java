package me.cxis.dcc.support;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.framework.api.CuratorListener;

public class ZkWatcher implements CuratorListener {


    @Override
    public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
        System.out.println("监听，event: " + event);
        if (event.getType() == CuratorEventType.WATCHED) {

        }
    }
}
