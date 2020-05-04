package me.cxis.dcc.manager;

import me.cxis.dcc.exception.ServiceException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static me.cxis.dcc.constants.Constants.PATH_SEPARATOR;
import static me.cxis.dcc.constants.Constants.ROOT_PATH;
import static me.cxis.dcc.model.ErrorCode.ZK_ERROR;

@Component
public class ZkManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZkManager.class);

    @Resource
    private CuratorFramework curatorFramework;


    public void push(String key, String value, String group) {
        try {
            String path = getPath(key, group);
            if (exists(path)) {
                curatorFramework.setData().forPath(path, value.getBytes());
            } else {
                curatorFramework.create().creatingParentsIfNeeded().forPath(path, value.getBytes());
            }
        } catch (Exception e) {
            LOGGER.warn("zookeeper error, cause: ", e);
            throw new ServiceException(ZK_ERROR);
        }
    }

    public boolean exists(String path) {
        try {
            Stat stat = curatorFramework.checkExists().forPath(path);
            return stat != null;
        } catch (Exception e) {
            LOGGER.warn("zookeeper error, cause: ", e);
            throw new ServiceException(ZK_ERROR);
        }
    }

    private String getPath(String key, String group) {
        return ROOT_PATH + PATH_SEPARATOR + group + PATH_SEPARATOR + key;
    }
}
