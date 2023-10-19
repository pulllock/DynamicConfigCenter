package fun.pullock.dcc.dao;

import fun.pullock.dcc.dao.mapper.ConfigInstDOMapper;
import fun.pullock.dcc.dao.model.ConfigInstDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

@Repository
public class ConfigInstDao {

    @Resource
    private ConfigInstDOMapper configInsDOMapper;

    public boolean insert(ConfigInstDO configInstDO) {
        configInstDO.setCreatedTime(new Date());
        configInstDO.setModifiedTime(configInstDO.getCreatedTime());
        configInstDO.setVersion(1);
        return configInsDOMapper.insert(configInstDO) == 1;
    }

    public int updateByConfigAndEnvId(ConfigInstDO configInstDO) {
        return configInsDOMapper.updateByConfigAndEnvId(configInstDO);
    }
}
