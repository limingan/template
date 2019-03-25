package com.city.management.common.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * http工具类
 */
@Component
public class HttpUtils {
	private Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	@Autowired
	private RestTemplate restTemplate;
	
	public String httpGet(String url) {
		return httpGet(url, new HashMap<String,String>());
	}
	//get带入参，需要在url中加占位符，比如http://localhost:1111/user/getuserbyid?name={name}&id={id}
	public String httpGet(String url, Map<String,String> param) {
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, param);
			if(response != null && response.getStatusCode() == HttpStatus.OK){
				return response.getBody();
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.error("url:"+url+",param:"+param,e);
			return null;
		}
	}
	public String httpPost(String url) {
		return httpPost(url, null);
	}
	public String httpPost(String url, Map<String,Object> param) {
		MultiValueMap<String, String> headers = new HttpHeaders();
		//设置请求头content-type和接收类型accept，默认为：text/plain
//		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
//		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
		return httpPost(url, param, headers);
	}
	public String httpPost(String url, Map<String,Object> param, MultiValueMap<String, String> headers){
		try {
			URI uri;
			uri = new URI(url);
			MultiValueMap<String,Object> multiMap = new LinkedMultiValueMap<String,Object>();
			multiMap.setAll(param);
			RequestEntity<MultiValueMap<String,Object>> request = new RequestEntity<MultiValueMap<String,Object>>(multiMap, headers,HttpMethod.POST, uri);
			return exchange(url,HttpMethod.POST, request);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String exchange(String url, HttpMethod method, RequestEntity<MultiValueMap<String,Object>> requestEntity){
		long start = System.currentTimeMillis();
		ResponseEntity<String> response = restTemplate.exchange(url, method, requestEntity, String.class);
		System.out.println("响应时间："+ (System.currentTimeMillis()-start));
		HttpHeaders h = response.getHeaders();
		System.out.println("返回头："+h);
		if(response != null && response.getStatusCode() == HttpStatus.OK){
			String body = response.getBody();
			return body;
		}
		return null;
	}
	
}
