/**
 */
package com.foundation.springsecurity.secure.captcha;

import org.springframework.stereotype.Service;

/***
 * Date:2021/6/26
 * Title:Captcha 验证码服务
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Service
public class SecureCaptchaService {

//    @Resource
//    private RedisTemplate<String, String> redisTemplate;

    /**
     * Function:创建Captcha
     * Author: Admin
     * Date:2021/6/26
      * @param
     * @return com.bjtuwh.common.secure.captcha.SecureCaptcha
     * @throws Exception
     */
//    public SecureCaptcha createCaptcha(){
//        SpecCaptcha captcha = new SpecCaptcha(142,38);
//        String key = UUID.randomUUID().toString();
//        String code = captcha.text().toLowerCase();
//        redisTemplate.opsForValue().set(CacheNameConstant.CAPTCHA_NAME_PREFIX + key, code, SecurityConstant.CAPTCHA_EXPIRATION, TimeUnit.SECONDS);
//        return new SecureCaptcha(key,code,captcha.toBase64());
//    }

    /**
     * Function:验证Captcha
     * Author: Admin
     * Date:2021/6/26
      * @param key
     * @param code
     * @return void
     * @throws Exception
     */
//    public void verifyCaptcha(String key, String code) {
//        String redisCode = taskCaptcha(key);
//        if(redisCode == null){
//            throw new CaptchaExpiredException("captcha expired");
//        }
//        if(!redisCode.equals(code)) {
//            throw new CaptchaValidationException("captcha invalid");
//        }
//    }

    /**
     * Function:获取Captcha
     * Author: Admin
     * Date:2021/6/26
      * @param key
     * @return java.lang.String
     * @throws Exception
     */
//    public String taskCaptcha(String key) {
//        return redisTemplate.opsForValue().get(CacheNameConstant.CAPTCHA_NAME_PREFIX + key);
//    }

    /**
     * Function:销毁Captcha
     * Author: Admin
     * Date:2021/6/26
      * @param key
     * @return void
     * @throws Exception
     */
//    public void destroyCaptcha(String key){
//        redisTemplate.delete(CacheNameConstant.CAPTCHA_NAME_PREFIX + key);
//    }
}
