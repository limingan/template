package com.city.management.common.cache;

import com.city.management.collection.mapper.UserInfoMapper;
import com.city.management.collection.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 内存缓存，用于缓存开关，基础数据等
 */
@Component
public class UserInfoCaffeine {
	private Logger logger = LoggerFactory.getLogger(UserInfoCaffeine.class);
	private UserInfo userInfo;
	@Autowired
	private UserInfoMapper mapper;
	@Cacheable(value="commonCaffeine", key="'userinfo'+#accountId")
	public UserInfo getUserInfoByAccountId(String accountId){
		logger.info("从缓存获取不到，改为查数据库");
		//模拟从数据库获取
		userInfo = new UserInfo();
		userInfo.setUserId("id");
		userInfo.setUserName("name");
		//userInfo = mapper.getUserInfoById(accountId);
		logger.info("从缓存获取不到，查数据库成功"+userInfo);
		return userInfo;
	}
	@CachePut(value="commonCaffeine", key="'userinfo'+#user.accountId")
	public UserInfo putUserInfo(UserInfo user){
		logger.info("查数据库，放入缓存");
		//mapper.updateUserInfo(user);
		return user;
	}
	@CacheEvict(value="commonCaffeine", key="'userinfo'+#accountId")
	public void remove(String accountId){
		userInfo=null;
		logger.info("从缓存删除");
	}

	@Cacheable(value="commonCaffeine22", key="'userinfo22'+#accountId")
	public UserInfo getUserInfo(String accountId){
		logger.info("从缓存获取不到，改为查数据库33");
		//模拟从数据库获取
		userInfo = new UserInfo();
		userInfo.setUserId("id22");
		userInfo.setUserName("name22");
		//userInfo = mapper.getUserInfoById(accountId);
		logger.info("从缓存获取不到，查数据库成功33"+userInfo);
		return userInfo;
	}
}
