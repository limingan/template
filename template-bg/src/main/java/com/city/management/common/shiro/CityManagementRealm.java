package com.city.management.common.shiro;

import com.city.management.collection.mapper.UserInfoMapper;
import com.city.management.collection.model.UserInfo;
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
	private UserInfoMapper userInfoMapper;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("调用权限验证方法");
		if(principals == null || StringUtils.isBlank((String)principals.getPrimaryPrincipal())){
			return null;
		}
		String username = (String)principals.getPrimaryPrincipal();//获取当前用户
		List<Map<String,Object>> rolePermissionList = userInfoMapper.getRoleAndPermissionByUsername(username);
		Set<String> permissions = new HashSet<String>();
		if(CollectionUtils.isNotEmpty(rolePermissionList)){
			for(Map<String,Object> roleMap : rolePermissionList) {
				permissions.add((String)roleMap.get("permissionName"));
			}
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
		UserInfo userInfo = userInfoMapper.getUserInfoByName(userName);
		if(userInfo == null) {
			return null;
		}
		return new SimpleAuthenticationInfo(userInfo.getUserName(), userInfo.getPassword(), 
				ByteSource.Util.bytes(userInfo.getUserName()), getName() );
	}

}
