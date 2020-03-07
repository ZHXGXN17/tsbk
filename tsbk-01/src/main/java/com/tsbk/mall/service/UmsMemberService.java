package com.tsbk.mall.service;

import com.tsbk.mall.common.api.CommonResult;

/**
 * 会员管理Service
 * Created by yufei.wang on 2020-03-06.
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone:手机号
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone:手机号
     * @param authCode:验证码
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
