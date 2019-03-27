package com.city.management.common.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019-03-27.
 */
@Component
public class CityManagementPermissionFilter extends PermissionsAuthorizationFilter{
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        OutputStream os = response.getOutputStream();
        Map<String,Object> result = new HashMap<String,Object>();
        //无用户则提示登录，否则提示无权限
        if (subject.getPrincipal() == null) {
            result.put("msg", "请先登录");
            result.put("code", "4001");
            os.write(result.toString().getBytes("GBK"));
            os.flush();
            os.close();
        } else {
            result.put("msg", "您没有访问该资源的权限");
            result.put("code", "3001");
            os.write(result.toString().getBytes("GBK"));
            os.flush();
            os.close();
        }
        return false;
    }
}
