package com.tsbk.mall.service.impl;

import com.tsbk.mall.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis操作Service的实现类
 * Created by yufei.wang on 2020-03-06.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire){
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    @Override
    public void remove(String key){
        stringRedisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta){
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}

