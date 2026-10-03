package com.foundation.springsecurity.wecom;

/**
 * Copyright 2019 Zhongke ruicheng (Beijing) information technology co. LTD
 * All right reserved.
 * 项目名称: 北京交通大学（威海）约车系统
 * 创建日期: 2021/7/19
 */

import cn.hutool.http.HttpRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foundation.springcontext.bean.BeanContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


/**
 * 创建日期: 2021/7/19
 * Title: 企业微信网页身份认证业务接口具体实现类
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author DSH
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Slf4j
public class WecomAuth {
    ObjectMapper  objectMapper = null;
    public WecomAuth(){
        objectMapper = (ObjectMapper) BeanContext.getBean("objectMapper");
    }
    public  String getAccessToken(String corpId, String agentSecret) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=").append(corpId).append("&corpsecret=").append(agentSecret);
        log.info("开始获取wx token");
        String url = sb.toString();
        String token = null;
        String tokenResult = null;
        try {
            token = HttpRequest.get(url).execute().body();
            Map<String, String> stringStringtMap = objectMapper.readValue(token, new TypeReference<Map<String,String>>(){});
            tokenResult = stringStringtMap.get("access_token");
            log.info("获取access_token：" + tokenResult);
        } catch (Exception e) {
             e.printStackTrace();
        }
        return tokenResult;
    }
    public  String getUserId(String corpId, String agentSecret,String code)  {
        String accessToken = this.getAccessToken(corpId, agentSecret);
        StringBuilder sb = new StringBuilder();
        sb.append("https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=").append(accessToken).append("&code=").append(code);
        String url = sb.toString();
        String userId = null;
        try {
            String errorCode0 = "0";
            String userInfo = HttpRequest.get(url).execute().body();
            Map<String, String> stringStringtMap = objectMapper.readValue(userInfo, new TypeReference<Map<String,String>>(){});
            String errcode = stringStringtMap.get("errcode");
            if (errorCode0.equals(errcode)) {
                userId = stringStringtMap.get("UserId");
            } else {
                log.error("获取企业微信访问用户身份ID异常：{}", userInfo);
                throw new Exception(errcode);
            }
            log.info("user信息："+ userId);
        } catch (Exception e) {
            log.info("获取企业微信访问用户身份信息异常： {}", e.getMessage());
            e.printStackTrace();
        }
        return userId;
    }
}
