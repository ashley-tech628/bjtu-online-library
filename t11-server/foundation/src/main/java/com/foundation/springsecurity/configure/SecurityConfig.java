/**
 */
package com.foundation.springsecurity.configure;

import com.foundation.springsecurity.constant.SecurityConstant;
import com.foundation.springsecurity.secure.process.*;
import com.foundation.springsecurity.secure.uutoken.SecureUserTokenSupport;
import com.foundation.springcontext.configure.IgnoreUrlsConfig;
import com.foundation.springsecurity.wecom.WecomCodeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.AntPathMatcher;


import static org.springframework.security.config.Customizer.withDefaults;

/***
 * Date:2021/6/26
 * Title:安全核心配置类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    /**
     * 自定义登陆成功处理器
     */
    @Bean
    public SecureLoginSuccessHandler secureLoginSuccessHandler(){
        return new SecureLoginSuccessHandler();
    }

    /**
     * 自定义登陆失败处理器
     */
    @Bean
    public SecureLoginFailureHandler secureLoginFailureHandler(){
        return new SecureLoginFailureHandler();
    }

    /**
     * 自定义注销成功处理器
     */
    @Bean
    public SecureLogoutSuccessHandler secureLogoutSuccessHandler(){
        return new SecureLogoutSuccessHandler();
    }

    /**
     * 自定义暂无权限处理器
     */
    @Bean
    public SecureNoPermissionHandler secureNoPermissionHandler(){
        return new SecureNoPermissionHandler();
    }

    /**
     * 自定义未登录的处理器
     */
    @Bean
    public SecureNoAuthenticationHandler secureNoAuthenticationHandler(){
        return new SecureNoAuthenticationHandler();
    }
    /**
     * 密码加密方式
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**
     * Function:Http Security 核心配置
     * Author: Admin
     * Date:2021/6/26
     * @param http
     * @return void
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /**
         * 不存在的资源，直接跳转到/login
         * 存在的资源，白名单的放行
         */
        http.removeConfigurer(DefaultLoginPageConfigurer.class);
//        http.authorizeHttpRequests((authz) -> {
//                    authz.requestMatchers("/**").permitAll();
////                    authz.requestMatchers(HttpMethod.OPTIONS).permitAll();
////                    authz.anyRequest().authenticated();
////                    authz.requestMatchers(ignoreUrlsConfig().getUrls().toArray(new String[0])).anonymous();
//                }
//        );
        http.httpBasic(withDefaults())
                //配置登录地址
                .formLogin()
                // or post  http://localhost:9090/api/user/login username password
                //存body form data
                .loginProcessingUrl(SecurityConstant.LOGIN_URL)
                //配置登录成功自定义处理类
                .successHandler(secureLoginSuccessHandler())
                //配置登录失败自定义处理类
                .failureHandler(secureLoginFailureHandler());
                //配置登出地址
        http.logout()
                .logoutUrl(SecurityConstant.LOGOUT_URL)
                //配置用户登出自定义处理类
                .logoutSuccessHandler(new SecureLogoutSuccessHandler());
                //配置没有登录自定义处理类;
//        http.exceptionHandling().authenticationEntryPoint(secureNoAuthenticationHandler());
                //配置没有权限自定义处理类
        http.exceptionHandling().accessDeniedHandler(secureNoPermissionHandler());
                // 取消跨站请求伪造防护
        http.csrf().disable();
        // 处理 Iframe 响应
        http.headers().frameOptions().disable();

        // 基于 Token 不需要 session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //WecomFilter
        http.addFilterBefore(new WecomCodeFilter(), UsernamePasswordAuthenticationFilter.class);
        //自定义基于JWT拦截的过滤器,在指定的beforeFilter之前加入filter
        http.addFilterBefore(new SecureUserTokenSupport(), UsernamePasswordAuthenticationFilter.class);
        //Captcha过滤器
        /**http.addFilterBefore(new SecureCaptchaSupport(), UsernamePasswordAuthenticationFilter.class);*/

        // 禁用缓存
        http.headers().cacheControl();

        // 开启 Security 跨域
        http.cors();
        return http.build();
    }

    @Bean
    public AntPathMatcher antPathMatcher() {
        return new AntPathMatcher();
    }

    /**
     * 自定义白名单
     * @return 白名单配置类
     */
    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    /**
     * passwordEncoder
     * @param args
     */
    public static void main(String[] args) {
        String pwd = "spring1234";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode(pwd);
        String encode2 = bCryptPasswordEncoder.encode(pwd);
        System.out.println("aa "+encode1);
        System.out.println("aa "+encode2);
        boolean matches1 = bCryptPasswordEncoder.matches(pwd, "$2a$10$iWZUkq5VhUTKbqlS0x528.LgJPHIKkNtS5Ei/oQKRLyEEnNVp6Jd.");
        System.out.println("m1 "+ matches1);
        boolean matches2 = bCryptPasswordEncoder.matches(pwd, encode2);
        System.out.println("m2 "+matches2);
    }

}