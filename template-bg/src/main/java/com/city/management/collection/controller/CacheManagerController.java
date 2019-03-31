package com.city.management.collection.controller;

import com.city.management.common.cache.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cp on 2019-03-28.
 */
@RestController
public class CacheManagerController {
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/delkey.do")
    public void delRedisKey(@RequestParam String[] keys){
        if(keys != null){
            for(String key : keys){
                redisUtil.del(key);
            }
        }
    }
}
