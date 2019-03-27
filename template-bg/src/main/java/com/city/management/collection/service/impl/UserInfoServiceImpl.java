package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.base.UserInfoMapper;
import com.city.management.collection.mapper.ext.UserInfoExtMapper;
import com.city.management.collection.model.base.UserInfo;
import com.city.management.collection.model.base.UserInfoExample;
import com.city.management.collection.service.UserInfoService;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cp on 2019-03-26.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoExtMapper userInfoExtMapper;
    @Override
    public UserInfo getUserInfoByName(String username) {
        UserInfo userInfo = new UserInfo();
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(list)){
            userInfo = list.get(0);
        }
        return userInfo;
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getPermissionByUsername(String username) {
        if(StringUtils.isBlank(username)){
            return new ArrayList<Map<String, Object>>();
        }
        return userInfoExtMapper.getPermissionByUsername(username);
    }
}
