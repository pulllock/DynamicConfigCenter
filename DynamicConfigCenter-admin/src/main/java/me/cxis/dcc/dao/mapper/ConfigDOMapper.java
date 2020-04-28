package me.cxis.dcc.dao.mapper;

import me.cxis.dcc.dao.model.ConfigDO;

public interface ConfigDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ConfigDO record);

    int insertSelective(ConfigDO record);

    ConfigDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigDO record);

    int updateByPrimaryKey(ConfigDO record);
}