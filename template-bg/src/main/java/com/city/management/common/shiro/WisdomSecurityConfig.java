package com.city.management.common.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class WisdomSecurityConfig {
	@Autowired
	private AuthorizingRealm wisdomRealm;
	@Autowired
	private WisdomSessionManager wisdomSessionManager;
	@Autowired
	private WisdomAuthcFilter wisdomAuthcFilter;
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//		sessionManager.setSessionIdUrlRewritingEnabled(false); //避免url中出现jsessionid
//		sessionManager.setGlobalSessionTimeout(sessionExpire);
//		sessionManager.setSessionValidationInterval(sessionValidationInterval);
//		sessionManager.setSessionValidationSchedulerEnabled(false);
//		sessionManager.setCacheManager(redisCacheManager);
//		redisSessionDAO.setCacheManager(redisCacheManager);
//		sessionManager.setSessionDAO(redisSessionDAO);
//		wisdomRealm.setAuthorizationCachingEnabled(true);
//		wisdomRealm.setAuthenticationCachingEnabled(true);
		securityManager.setRealm(wisdomRealm);
		securityManager.setSessionManager(wisdomSessionManager);
		return securityManager;
	}
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(){
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		Map<String,String> map = new LinkedHashMap();
		Map<String, Filter> filters = new LinkedHashMap<String,Filter>();
		filters.put("wisdomAuthcFilter", wisdomAuthcFilter);
		setUnAuthUrl(map);
		map.put("/collection/logout.do", "logout");
		map.put("/common/**", "perms[select]");
//		map.put("/wisdom/**", "wisdomAccessFilter");
		map.put("/**/*.do", "authc");
		shiroFilter.setSecurityManager(securityManager());
		shiroFilter.setLoginUrl("/collection/login.do");
		shiroFilter.setUnauthorizedUrl("/collection/unAuth.do");
		shiroFilter.setFilters(filters);
		shiroFilter.setFilterChainDefinitionMap(map);
		return shiroFilter;
	}
	//从配置文件中获取不需要验权的url
	private void setUnAuthUrl(Map<String,String> authcMap){
		authcMap.put("/templates/*", "anon");
		authcMap.put("/favicon.ico", "anon");
		authcMap.put("/collection/login.do", "anon");
	}
	@Bean
	public FilterRegistrationBean registration(WisdomAuthcFilter wisdomAuthcFilter) {
	    FilterRegistrationBean registration = new FilterRegistrationBean(wisdomAuthcFilter);
	    registration.setEnabled(false);
	    return registration;
	}
}
