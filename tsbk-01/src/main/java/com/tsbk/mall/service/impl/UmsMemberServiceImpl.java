package com.tsbk.mall.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.tsbk.mall.common.api.CommonResult;
import com.tsbk.mall.service.RedisService;
import com.tsbk.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 会员管理Service实现类
 * Created by yufei.wang on 2020-03-06.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            stringBuilder.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, stringBuilder.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(stringBuilder.toString(), "获取验证码成功");
    }

    //对输入的验证码进行校验
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode){
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if(result){
            return CommonResult.success(null, "验证码校验成功");
        }else{
            return CommonResult.failed("验证码不正确");
        }
    }
}



