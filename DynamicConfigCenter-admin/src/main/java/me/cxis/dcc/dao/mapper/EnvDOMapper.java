package me.cxis.dcc.dao.mapper;

import me.cxis.dcc.dao.model.EnvDO;

public interface EnvDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EnvDO record);

    int insertSelective(EnvDO record);

    EnvDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnvDO record);

    int updateByPrimaryKey(EnvDO record);
}