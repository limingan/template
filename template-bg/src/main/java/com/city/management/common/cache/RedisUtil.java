package com.city.management.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	public void set(String key, Object value, long expire){
		redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
	}
	public void set(String key, Object value){
		redisTemplate.opsForValue().set(key, value);
	}
	public void del(String key){
		redisTemplate.delete(key);
	}
}
