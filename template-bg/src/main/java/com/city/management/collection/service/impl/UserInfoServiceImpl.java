package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.base.UserInfoMapper;
import com.city.management.collection.model.base.UserInfo;
import com.city.management.collection.model.base.UserInfoExample;
import com.city.management.collection.service.UserInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cp on 2019-03-26.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper mapper;
    @Override
    public UserInfo getUserInfoByName(String username) {
        UserInfo userInfo = new UserInfo();
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<UserInfo> list = mapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(list)){
            userInfo = list.get(0);
        }
        return userInfo;
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return null;
    }
}
