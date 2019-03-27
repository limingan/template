package com.city.management.common.cache;

/**
 * Created by Administrator on 2019-03-27.
 */
public enum  RedisConstants {
    PERMISSION("permission_", 3600);
    String key;
    int expire;
     RedisConstants(String key, int expire){
        this.key = key;
        this.expire = expire;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
