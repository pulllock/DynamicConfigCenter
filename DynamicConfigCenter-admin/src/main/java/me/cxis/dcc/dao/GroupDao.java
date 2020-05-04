package me.cxis.dcc.dao;

import me.cxis.dcc.dao.mapper.GroupDOMapper;
import me.cxis.dcc.dao.model.GroupDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class GroupDao {

    @Resource
    private GroupDOMapper groupDOMapper;

    public boolean insert(GroupDO groupDO) {
        return groupDOMapper.insertSelective(groupDO) == 1;
    }

    public GroupDO queryById(Long id) {
        return groupDOMapper.selectByPrimaryKey(id);
    }
}
