package com.city.management.common.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import java.io.Serializable;
@Component
public class CityManagementSessionManager extends DefaultWebSessionManager {
	
	public CityManagementSessionManager(RedisSessionDAO redisSessionDAO){
		super.setSessionDAO(redisSessionDAO);
	}
	//解决一次请求多次调用redis获取session问题
	@Override
	protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
		 Serializable sessionId = getSessionId(sessionKey);
		 ServletRequest request = null;
		 if(sessionKey instanceof WebSessionKey){
			 request = ((WebSessionKey) sessionKey).getServletRequest();
		 }
		 if(request != null && sessionId != null){
			 Object obj = request.getAttribute(sessionId.toString());
			 if(obj != null){
				 return (Session) obj;
			 }
		 }
		 Session session = super.retrieveSession(sessionKey);
		 if(request != null && sessionId != null){
			 request.setAttribute(sessionId.toString(), session);
		 }
		 return session;
	}
	
//	@Override
//    public Serializable getSessionId(SessionKey key) {
//        Serializable id = key.getSessionId();
//        if (id == null && WebUtils.isWeb(key)) {
//            HttpServletRequest request = WebUtils.getHttpRequest(key);
//            HttpServletResponse response = WebUtils.getHttpResponse(key);
//            id = getSessionId(request, response);
//        }
//        HttpServletRequest request = WebUtils.getHttpRequest(key);
//        request.setAttribute("token", id);
//        System.out.println("返回token1:"+id);
//        return id;
//    }
//
//	protected Serializable getSessionId(HttpServletRequest request, HttpServletResponse response) {
//		String token = request.getParameter("token");
////		if(StringUtils.isBlank(token)){
////			token = UUID.randomUUID().toString();
////			System.out.println("url:"+request.getRequestURI()+",返回token:"+token);
////		}
//        return token;
//    }
}
