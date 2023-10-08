package com.anil.redisapp.api;

import com.anil.redisapp.service.RedisCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    private RedisCacheService redisCacheService;
    private int sayac = 0;

    public RedisCacheController(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if(sayac == 5){
            redisCacheService.clearCache();
            sayac = 0;
        }
        sayac++;
        return redisCacheService.longRunningMethod();
    }
}
