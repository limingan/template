package com.city.management.collection.controller;

import com.city.management.collection.model.base.Permission;
import com.city.management.collection.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PermissionController {


    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/permission/list.do")
    public String list(HttpServletRequest request) {
        List<Permission> permissionList = permissionService.queryAll();
        return "login bb " + permissionList;
    }
}
