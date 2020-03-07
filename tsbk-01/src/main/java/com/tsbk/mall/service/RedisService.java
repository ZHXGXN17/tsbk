package com.tsbk.mall.service;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * Created by yufei.wang on 2020-03-06.
 */
public interface RedisService {

    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     */
    Long increment(String key, long delta);
}
