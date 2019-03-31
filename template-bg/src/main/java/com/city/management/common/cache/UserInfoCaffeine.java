package com.city.management.common.cache;

import com.city.management.collection.model.base.UserInfo;
import com.city.management.collection.service.impl.UserInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 内存缓存示例，用于缓存开关，基础数据等
 * 使用时只需要用注解即可，@Cacheable
 */
@Component
public class UserInfoCaffeine {
	private Logger logger = LoggerFactory.getLogger(UserInfoCaffeine.class);
	private UserInfo userInfo;
	@Autowired
	private UserInfoServiceImpl userInfoService;
	/**
	 * Cacheable
	 * value：缓存key的前缀。
	 * key：缓存key的后缀。
	 * sync：缓存过期时，异步请求数据库，只有一个线程去取，其他请求阻塞，默认是false。
	 */
	@Cacheable(value="commonCaffeine", key="'userinfo'+#accountId",sync=true)
	public UserInfo getUserInfoByAccountId(String accountId){
		logger.info("从缓存获取不到，改为查数据库");
		userInfo = userInfoService.getUserInfoById(accountId);
		logger.info("从缓存获取不到，查数据库成功"+userInfo);
		return userInfo;
	}

	/**
	 * public @interface Caching {
	 	Cacheable[] cacheable() default {}; //声明多个@Cacheable
	 	CachePut[] put() default {};        //声明多个@CachePut
	 	CacheEvict[] evict() default {};    //声明多个@CacheEvict
	 */
	@CachePut(value="commonCaffeine", key="'userinfo'+#user.accountId")
	public UserInfo putUserInfo(UserInfo user){
		logger.info("查数据库，放入缓存");
//		mapper.updateUserInfo(user);
		return user;
	}
	//移除具体key， allEntries=true表示移除所有key
	@CacheEvict(value="commonCaffeine", key="'userinfo'+#accountId")
	public void remove(String accountId){
		userInfo=null;
		logger.info("从缓存删除");
	}
	@Cacheable(value="commonCaffeine22", key="'userinfo22'+#accountId")
	public UserInfo getUserInfo(String accountId){
		logger.info("从缓存获取不到，改为查数据库33");
		userInfo = userInfoService.getUserInfoById(accountId);
		logger.info("从缓存获取不到，查数据库成功33"+userInfo);
		return userInfo;
	}
}
