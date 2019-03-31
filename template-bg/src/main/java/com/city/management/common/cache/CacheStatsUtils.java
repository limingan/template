package com.city.management.common.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.stats.CacheStats;

/**
 * Created by Administrator on 2019-03-28.
 */
public class CacheStatsUtils {
    public static void main(String[] args){
        Cache<Object, Object> stats = Caffeine.newBuilder().recordStats().build();
        CacheStats cs = stats.stats();
        System.out.println(cs.hitCount());
        System.out.println(cs.evictionCount());
        System.out.println(cs.averageLoadPenalty());

    }
}
