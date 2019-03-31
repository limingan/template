package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.base.PermissionMapper;
import com.city.management.collection.model.base.Permission;
import com.city.management.collection.model.base.PermissionExample;
import com.city.management.collection.model.query.PermissionQuery;
import com.city.management.collection.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> queryAll() {
        logger.info("querAll no cache");
        PermissionExample example = new PermissionExample();
        return permissionMapper.selectByExample(example);
    }

    @Override
    public List<Permission> queryList(PermissionQuery query) {
        PermissionExample example = new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        criteria.andPermissionNameLike(query.getPermissionName());
        return permissionMapper.selectByExample(example);
    }


}
