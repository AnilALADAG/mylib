package com.anil.redisapp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(3000L);
        return "method was ran";
    }

    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache(){
        System.out.println("cache was cleared.");
    }
}
