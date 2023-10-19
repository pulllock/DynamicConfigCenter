package fun.pullock.dcc.dao.mapper;

import fun.pullock.dcc.dao.model.GroupDO;

public interface GroupDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GroupDO record);

    int insertSelective(GroupDO record);

    GroupDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupDO record);

    int updateByPrimaryKey(GroupDO record);
}