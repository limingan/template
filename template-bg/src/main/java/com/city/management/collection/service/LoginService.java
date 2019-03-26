package com.city.management.collection.service;

import com.city.management.collection.model.base.UserInfo;

import java.util.Map;

/**
 * Created by Administrator on 2019-03-23.
 */
public interface LoginService {
    public UserInfo getUserByName(String name);
    public Map<String,Object> login(String userName, String password);
}
