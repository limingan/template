package com.city.management.collection.service;

import com.city.management.collection.model.UserInfo;

/**
 * Created by Administrator on 2019-03-23.
 */
public interface LoginService {
    public UserInfo getUserByName(String name);
}
