package fun.pullock.dcc.dao;

import fun.pullock.dcc.dao.mapper.ConfigDOMapper;
import fun.pullock.dcc.dao.model.ConfigDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

@Repository
public class ConfigDao {

    @Resource
    private ConfigDOMapper configDOMapper;

    public boolean insert(ConfigDO configDO) {
        configDO.setCreatedTime(new Date());
        configDO.setModifiedTime(configDO.getCreatedTime());
        configDO.setVersion(1);
        return configDOMapper.insert(configDO) == 1;
    }

    public ConfigDO queryByKeyAndGroupId(String key, Long groupId) {
        return configDOMapper.selectByKeyAndGroupId(key, groupId);
    }

    public int updateByPrimaryKeySelective(ConfigDO configDO) {
        return configDOMapper.updateByPrimaryKeySelective(configDO);
    }

    public ConfigDO queryById(Long id) {
        return configDOMapper.selectByPrimaryKey(id);
    }
}
