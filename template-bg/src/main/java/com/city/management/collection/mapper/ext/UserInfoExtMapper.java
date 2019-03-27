package com.city.management.collection.mapper.ext;

import java.util.List;
import java.util.Map;

/**
 * Created by cp on 2019-03-23.
 */
public interface UserInfoExtMapper {
    public List<Map<String,Object>> getPermissionByUsername(String username);
}
