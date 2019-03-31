package com.city.management.common.cache;

/**
 * redis和本地缓存的key和expire 常量类
 * Created by cp on 2019-03-27.
 */
public class CacheConstants {
    //caffeine常量
    public static String userInfoKey = "userinfo_";
    public static int userInfoExpire = 600;
    //redis常量
    public static enum CacheEnum{
        PERMISSION("permission_", 3600);
        String key;
        int expire;
        CacheEnum(String key, int expire){
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
}
