package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.UserInfoMapper;
import com.city.management.collection.model.UserInfo;
import com.city.management.collection.service.LoginService;
import com.city.management.common.cache.UserInfoCaffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019-03-23.
 */
@Component
public class LoginServiceImpl implements LoginService{
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private UserInfoMapper mapper;
    @Autowired
    private UserInfoCaffeine userInfoCaffeine;
    @Override
    public UserInfo getUserByName(String name) {
        UserInfo userInfo = userInfoCaffeine.getUserInfo(name);
        logger.info("ssss"+userInfo.getUserName());
        return userInfoCaffeine.getUserInfoByAccountId(name);
    }
}
