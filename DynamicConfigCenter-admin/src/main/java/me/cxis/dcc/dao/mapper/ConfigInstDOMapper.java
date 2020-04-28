package me.cxis.dcc.dao.mapper;

import me.cxis.dcc.dao.model.ConfigInstDO;

public interface ConfigInstDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ConfigInstDO record);

    int insertSelective(ConfigInstDO record);

    ConfigInstDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigInstDO record);

    int updateByPrimaryKey(ConfigInstDO record);
}