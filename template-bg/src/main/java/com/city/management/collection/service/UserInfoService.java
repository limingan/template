package com.city.management.collection.service;

import com.city.management.collection.model.base.UserInfo;

/**
 * Created by Administrator on 2019-03-26.
 */
public interface UserInfoService {
    public UserInfo getUserInfoByName(String username);
    public UserInfo getUserInfoById(String id);
}
