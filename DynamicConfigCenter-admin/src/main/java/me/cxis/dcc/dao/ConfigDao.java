package me.cxis.dcc.dao;

import me.cxis.dcc.dao.mapper.ConfigDOMapper;
import me.cxis.dcc.dao.model.ConfigDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ConfigDao {

    @Resource
    private ConfigDOMapper configDOMapper;

    public boolean insert(ConfigDO configDO) {
        return configDOMapper.insertSelective(configDO) == 1;
    }
}
