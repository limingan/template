package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.base.UserInfoMapper;
import com.city.management.collection.model.base.UserInfo;
import com.city.management.collection.model.base.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cp on 2019-03-26.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper mapper;
    @Override
    public UserInfo getUserInfoByName() {
        UserInfoExample example = new UserInfoExample();
        mapper.selectByExample(example);
        return null;
    }
}
