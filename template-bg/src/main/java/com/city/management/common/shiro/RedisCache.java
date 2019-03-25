package com.city.management.common.shiro;

import com.city.management.common.cache.RedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
@Component
public class RedisCache<K extends String,V extends Object> implements Cache<K, V> {
	
	@Autowired
	private RedisUtil redisUtil;
	@Value("${shiro.redis.cacheManager.expire}")
	private long expire;
	@Override
	public Object get(String paramK) throws CacheException {
		System.out.println("redisCache get():"+paramK);
		return redisUtil.get(paramK);
	}

	@Override
	public Object put(String paramK, Object paramV) throws CacheException {
		System.out.println("redisCache put():"+paramK);
		redisUtil.set(paramK, paramV, expire);
		return paramV;
	}

	@Override
	public Object remove(String paramK) throws CacheException {
		System.out.println("redisCache remove():"+paramK);
		Object value = redisUtil.get(paramK);
		redisUtil.del(paramK);
		return value;
	}

	@Override
	public void clear() throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
