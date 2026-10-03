/**
 */
package com.t11;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import jakarta.servlet.MultipartConfigElement;
import java.net.InetAddress;
import java.net.UnknownHostException;

/***
 * Date:2021/6/26
 * Title:启动程序(必须放置在根包下，否则有些类注入不进来)
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author Admin
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Slf4j
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.t11","com.foundation"})
@MapperScan(basePackages = {"com.t11.**.mapper","com.foundation.**.mapper"})
public class T11Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(T11Application.class, args);
        Environment env = applicationContext.getEnvironment();
        String applicationName = env.getProperty("spring.application.name");
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String port = env.getProperty("server.port");

        log.info("\n--------------------------------------------\n" +
                "http://"+ ip +":"+ port +"\n" +
                "-----------------------------------------------");
    }

    /**
     * 功能: 设置Tomcat上传文件大小
     * 作者: DSH
     * 创建日期: 2021/9/12
     * @param
     * @return: MultipartConfigElement
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单文件最大值,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(1024 * 1, DataUnit.MEGABYTES));
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.of(1024 * 10, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }


}
