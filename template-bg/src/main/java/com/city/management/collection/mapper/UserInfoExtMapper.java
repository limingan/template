package com.city.management.collection.mapper;

import com.city.management.collection.model.base.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-03-23.
 */
public interface UserInfoExtMapper {
    public UserInfo getUserInfoByName(String name);
    public List<Map<String,Object>> getRoleByUsername(String username);
    public List<Map<String,Object>> getPermissionByUsername(String username);
}
