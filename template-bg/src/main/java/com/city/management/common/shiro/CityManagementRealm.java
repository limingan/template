package com.city.management.common.shiro;

import com.city.management.collection.model.base.UserInfo;
import com.city.management.collection.service.impl.UserInfoServiceImpl;
import com.city.management.common.cache.RedisConstants;
import com.city.management.common.cache.RedisUtil;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Component
public class CityManagementRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(CityManagementRealm.class);
	@Autowired
	private UserInfoServiceImpl userInfoService;
	@Autowired
	private RedisUtil redisUtil;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("调用权限验证方法");
		if(principals == null || StringUtils.isBlank((String)principals.getPrimaryPrincipal())){
			return null;
		}
		String username = (String)principals.getPrimaryPrincipal();//获取当前用户

		String key = RedisConstants.PERMISSION.getKey() + username;
		Set<String> permissions  = (Set<String>)redisUtil.get(key);
		if(CollectionUtils.isEmpty(permissions)) {
			permissions = new HashSet<String>();
			List<Map<String, Object>> rolePermissionList = userInfoService.getPermissionByUsername(username);
			if (CollectionUtils.isNotEmpty(rolePermissionList)) {
				for (Map<String, Object> roleMap : rolePermissionList) {
					permissions.add((String) roleMap.get("permissionName"));
				}
			}
			redisUtil.set(key, permissions,RedisConstants.PERMISSION.getExpire());
		}
		SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
		authorization.addStringPermissions(permissions);
		return authorization;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("调用鉴权方法");
		if(token == null || StringUtils.isBlank((String)token.getPrincipal())){
			return null;
		}
		String userName = (String) token.getPrincipal();
		UserInfo userInfo = userInfoService.getUserInfoByName(userName);
		if(userInfo == null) {
			return null;
		}
		return new SimpleAuthenticationInfo(userInfo.getUsername(), userInfo.getPassword(),
				ByteSource.Util.bytes(userInfo.getUsername()), getName() );
	}

}
