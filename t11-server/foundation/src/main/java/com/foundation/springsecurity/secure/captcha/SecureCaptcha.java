/**
 */
package com.foundation.springsecurity.secure.captcha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Date:2021/6/26
 * Title:Captcha 验证码实体
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecureCaptcha {

    /**
     * 标识
     */
    private String key;

    /**
     * 验证码
     */
    private String code;

    /**
     * 验证图片
     */
    private String image;

}
