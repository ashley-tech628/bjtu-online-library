package com.foundation.springcontext.bean;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

//@Component
public class CaffeineCache {
    @Resource
    Cache<String, Object> tokenCaffeineCache;
    public void setToken(String key,Object obj){
        if(null == key || null == obj)return;
        tokenCaffeineCache.put(key, obj);
    }
    public Object getToken(String key){
        return tokenCaffeineCache.getIfPresent(key);
    }
    public Object removeToken(String key){
        return tokenCaffeineCache.getIfPresent(key);
    }
    /*
    重新放入,以便重新计时
     */
    public void resetToken(String key){
       Object obj = this.getToken(key);
       if(null == obj)return;
       this.setToken(key, obj);
    }
}
