package me.cxis.dcc.dao;

import me.cxis.dcc.dao.mapper.EnvDOMapper;
import me.cxis.dcc.dao.model.EnvDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class EnvDao {

    @Resource
    private EnvDOMapper envDOMapper;

    public boolean insert(EnvDO envDO) {
        return envDOMapper.insertSelective(envDO) == 1;
    }

    public EnvDO queryById(Long id) {
        return envDOMapper.selectByPrimaryKey(id);
    }
}
