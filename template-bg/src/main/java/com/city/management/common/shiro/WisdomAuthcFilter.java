package com.city.management.common.shiro;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class WisdomAuthcFilter extends AuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		OutputStream os = response.getOutputStream();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("msg", "请先登录");
		result.put("code", "401");
		byte[] b = result.toString().getBytes();
		os.write(b);
		os.flush();
		os.close();
		return true;
	}

}
