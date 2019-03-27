package com.city.management.collection.service;

import com.city.management.collection.model.base.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-03-26.
 */
public interface UserInfoService {
    public UserInfo getUserInfoByName(String username);
    public UserInfo getUserInfoById(String id);
    public List<Map<String,Object>> getPermissionByUsername(String username);
}
