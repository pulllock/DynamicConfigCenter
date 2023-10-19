package fun.pullock.dcc.dao.mapper;

import fun.pullock.dcc.dao.model.EnvDO;

public interface EnvDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EnvDO record);

    int insertSelective(EnvDO record);

    EnvDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnvDO record);

    int updateByPrimaryKey(EnvDO record);
}