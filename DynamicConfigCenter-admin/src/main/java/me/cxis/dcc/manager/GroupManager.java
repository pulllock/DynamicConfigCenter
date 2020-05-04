package me.cxis.dcc.manager;

import me.cxis.dcc.dao.GroupDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GroupManager {

    @Resource
    private GroupDao groupDao;


}
