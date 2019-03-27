package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.base.UserInfoMapper;
import com.city.management.collection.model.base.UserInfo;
import com.city.management.collection.model.base.UserInfoExample;
import com.city.management.collection.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cp on 2019-03-26.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper mapper;
    @Override
    public UserInfo getUserInfoByName(String username) {
        UserInfoExample example = new UserInfoExample();
        mapper.selectByExample(example);
        return null;
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return null;
    }
}
