package me.cxis.dcc.manager;

import me.cxis.dcc.dao.ConfigDao;
import me.cxis.dcc.model.ConfigVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class ConfigManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);

    @Resource
    private ConfigDao configDao;

    @Transactional(rollbackFor = Exception.class)
    public boolean addConfig(ConfigVO config) {
        
        return false;
    }
}
