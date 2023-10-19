package fun.pullock.dcc.manager;

import fun.pullock.dcc.dao.GroupDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GroupManager {

    @Resource
    private GroupDao groupDao;


}
