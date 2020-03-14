package com.tsbk.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by yufei.wang on 2020-03-05.
 */
@Configuration
@MapperScan({"com.tsbk.mall.mbg.mapper", "com.tsbk.mall.dao"})
public class MyBatisConfig {
}
