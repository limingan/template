package com.city.management.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	public Object get(Object key) {
		return redisTemplate.opsForValue().get(key);
	}
	public void set(Object key, Object value, long expire){
		redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
	}
	public void set(Object key, Object value){
		redisTemplate.opsForValue().set(key, value);
	}
	public void del(Object key){
		redisTemplate.delete(key);
	}
	public boolean exists(String key){
		return redisTemplate.hasKey(key);
	}
	public long incr(String key){
		return redisTemplate.opsForValue().increment(key);
	}
	public long decr(String key){
		return redisTemplate.opsForValue().decrement(key);
	}
}
