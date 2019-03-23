package com.city.management.collection.controller;

import com.city.management.collection.model.UserInfo;
import com.city.management.collection.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cp on 2019-03-23.
 */
@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;
    @RequestMapping(value = "/collection/login.do")
    public String Login(HttpServletRequest request){
        String name = request.getParameter("name");
        UserInfo userInfo = loginService.getUserByName(name);
        return "login bb " + userInfo.getUserName();
    }
}
