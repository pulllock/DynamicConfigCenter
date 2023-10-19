package fun.pullock.dcc.dao.mapper;

import fun.pullock.dcc.dao.model.ConfigDO;
import org.apache.ibatis.annotations.Param;

public interface ConfigDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ConfigDO record);

    int insertSelective(ConfigDO record);

    ConfigDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigDO record);

    int updateByPrimaryKey(ConfigDO record);

    ConfigDO selectByKeyAndGroupId(@Param("key") String key, @Param("groupId") Long groupId);
}