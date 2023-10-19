package fun.pullock.dcc.dao.mapper;

import fun.pullock.dcc.dao.model.ConfigInstDO;

public interface ConfigInstDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ConfigInstDO record);

    int insertSelective(ConfigInstDO record);

    ConfigInstDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigInstDO record);

    int updateByPrimaryKey(ConfigInstDO record);

    int updateByConfigAndEnvId(ConfigInstDO configInstDO);
}