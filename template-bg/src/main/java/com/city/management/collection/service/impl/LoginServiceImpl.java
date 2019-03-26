package com.city.management.collection.service.impl;

import com.city.management.collection.mapper.UserInfoExtMapper;
import com.city.management.collection.model.base.UserInfo;
import com.city.management.collection.service.LoginService;
import com.city.management.common.cache.UserInfoCaffeine;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cp on 2019-03-23.
 */
@Component
public class LoginServiceImpl implements LoginService{
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private UserInfoExtMapper mapper;
    @Autowired
    private UserInfoCaffeine userInfoCaffeine;
    @Override
    public UserInfo getUserByName(String name) {
        return userInfoCaffeine.getUserInfoByAccountId(name);
    }

    @Override
    public Map<String, Object> login(String userName, String password) {
        Map<String,Object> loginResult = new HashMap<String,Object>();
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            loginResult.put("errorMsg", "参数不能为空!");
            return loginResult;
        }
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);
            loginResult.put("token", subject.getSession().getId());
            loginResult.put("userName", subject.getPrincipal());
        }catch(AuthenticationException e){
            loginResult.put("msg", "账号或密码错误！");
        }
        return loginResult;
    }
}
