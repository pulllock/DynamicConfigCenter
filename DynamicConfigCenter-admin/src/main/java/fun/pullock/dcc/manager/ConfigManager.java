package fun.pullock.dcc.manager;

import fun.pullock.dcc.dao.ConfigDao;
import fun.pullock.dcc.dao.ConfigInstDao;
import fun.pullock.dcc.dao.EnvDao;
import fun.pullock.dcc.dao.GroupDao;
import fun.pullock.dcc.dao.model.ConfigDO;
import fun.pullock.dcc.dao.model.ConfigInstDO;
import fun.pullock.dcc.dao.model.EnvDO;
import fun.pullock.dcc.dao.model.GroupDO;
import fun.pullock.dcc.exception.ServiceException;
import fun.pullock.dcc.model.ConfigVO;
import fun.pullock.dcc.model.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;

@Component
public class ConfigManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);

    @Resource
    private ConfigDao configDao;

    @Resource
    private GroupDao groupDao;

    @Resource
    private EnvDao envDao;

    @Resource
    private ConfigInstDao configInstDao;

    @Resource
    private ZkManager zkManager;

    @Transactional(rollbackFor = Exception.class)
    public boolean addConfig(ConfigVO config) {
        GroupDO groupDO = groupDao.queryById(config.getGroupId());
        if (groupDO == null) {
            throw new ServiceException(ErrorCode.GROUP_NOT_EXIST);
        }

        EnvDO envDO = envDao.queryById(config.getEnvId());
        if (envDO == null) {
            throw new ServiceException(ErrorCode.ENV_NOT_EXIST);
        }

        ConfigDO configDO = configDao.queryByKeyAndGroupId(config.getKey(), config.getGroupId());
        if (configDO != null) {
            throw new ServiceException(ErrorCode.CONFIG_EXISTED);
        }

        configDO = toConfigDO(config);
        configDO.setId(null);
        configDao.insert(configDO);

        ConfigInstDO configInstDO = new ConfigInstDO();
        configInstDO.setConfigId(configDO.getId());
        configInstDO.setEnvId(config.getEnvId());
        configInstDO.setValue(config.getValue());
        configInstDao.insert(configInstDO);

        zkManager.push(config.getKey(), config.getValue(), groupDO.getName());

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateConfig(ConfigVO config) {
        ConfigDO configDO = configDao.queryById(config.getId());
        if (configDO == null) {
            throw new ServiceException(ErrorCode.CONFIG_NOT_EXIST);
        }

        configDO = configDao.queryByKeyAndGroupId(config.getKey(), config.getGroupId());
        if (configDO == null) {
            throw new ServiceException(ErrorCode.CONFIG_NOT_EXIST);
        }

        GroupDO groupDO = groupDao.queryById(config.getGroupId());
        if (groupDO == null) {
            throw new ServiceException(ErrorCode.GROUP_NOT_EXIST);
        }

        EnvDO envDO = envDao.queryById(config.getEnvId());
        if (envDO == null) {
            throw new ServiceException(ErrorCode.ENV_NOT_EXIST);
        }

        configDO.setDesc(config.getDesc());
        configDO.setModifiedTime(new Date());
        configDO.setVersion(configDO.getVersion() + 1);
        configDao.updateByPrimaryKeySelective(configDO);

        ConfigInstDO configInstDO = new ConfigInstDO();
        configInstDO.setConfigId(configDO.getId());
        configInstDO.setEnvId(config.getEnvId());
        configInstDO.setValue(config.getValue());
        configInstDao.updateByConfigAndEnvId(configInstDO);

        zkManager.push(config.getKey(), config.getValue(), groupDO.getName());

        return true;
    }

    private ConfigDO toConfigDO(ConfigVO source) {
        if (source == null) {
            return null;
        }

        ConfigDO target = new ConfigDO();
        target.setId(source.getId());
        target.setKey(source.getKey());
        target.setGroupId(source.getGroupId());
        target.setDesc(source.getDesc());
        target.setType(source.getType());
        return target;
    }
}
