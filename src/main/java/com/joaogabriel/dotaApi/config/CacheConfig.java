package com.joaogabriel.dotaApi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableCaching
public class CacheConfig {

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void init() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::clearCache, 6, 6, TimeUnit.HOURS);
    }

    private void clearCache() {
        for (String cacheName : cacheManager.getCacheNames()) {
            ConcurrentMapCache cache = (ConcurrentMapCache) cacheManager.getCache(cacheName);
            if(cache != null) {
                cache.clear();
            }
        }
    }

}
