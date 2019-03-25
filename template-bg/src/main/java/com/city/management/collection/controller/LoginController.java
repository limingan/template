package com.city.management.collection.controller;

import com.city.management.collection.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cp on 2019-03-23.
 */
@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;
    @RequestMapping(value = "/collection/login.do")
    public String Login(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Map<String,Object> userInfo = loginService.login(userName, password);
        return "login bb " + userInfo;
    }
}
