package com.city.management.collection.service;

import com.city.management.collection.model.base.Permission;
import com.city.management.collection.model.query.PermissionQuery;

import java.util.List;

public interface PermissionService {

    List<Permission> queryAll();

    List<Permission> queryList(PermissionQuery query);
}
