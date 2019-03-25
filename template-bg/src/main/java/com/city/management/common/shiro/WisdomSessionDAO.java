package com.city.management.common.shiro;

import com.city.management.common.cache.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class WisdomSessionDAO extends CachingSessionDAO{
	private static long redisExpire = 600;
	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	protected void doUpdate(Session session) {
		if(session != null){
			Serializable sessionId = session.getId();
			System.out.println("调用doUpdate:"+sessionId);
			redisUtil.set(sessionId.toString(), session, redisExpire);
		}
	}

	@Override
	protected void doDelete(Session session) {
		if(session != null){
			Serializable sessionId = session.getId();
			redisUtil.del(sessionId.toString());
		}
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		System.out.println("调用doCreate:"+sessionId);
		assignSessionId(session, sessionId);
		redisUtil.set(sessionId.toString(), session, redisExpire);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		if(sessionId == null){
			return null;
		}
		System.out.println("调用doReadSession:"+sessionId);
		Session session = (Session) redisUtil.get(sessionId.toString());
		return session;
	}

}
