/**
 */
package com.foundation.springcontext.configure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.foundation.FoundationConstant;
import com.foundation.springcontext.bean.BeanContext;
import com.foundation.springcontext.bean.CaffeineCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/***
 * Date:2021/6/26
 * Title:核心配置
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author Admin
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Configuration
public class CoreConfig implements WebMvcConfigurer {
    private static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    @Bean
    public BeanContext beanContext() {
        return new BeanContext();
    }
    @Bean
    public CaffeineCache caffeineCache() {
        return new CaffeineCache();
    }
    @Bean
    public Cache tokenCaffeineCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(30, TimeUnit.MINUTES)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(1000)
                .build();
    }


   /**
     * Function:跨域配置
     * Author: Admin
     * Date:2021/6/26
     * @param
     * @return org.springframework.web.filter.CorsFilter
     * @throws Exception
     */
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig());
//
//        return new CorsFilter(source);
//    }

    /**
     * Function:跨域配置
     * Author: Admin
     * Date:2021/6/26
     * @param
     * @return org.springframework.web.cors.CorsConfiguration
     * @throws Exception
     */
//    private CorsConfiguration corsConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        List<String> allowedOriginPatterns = new ArrayList<>();
//        allowedOriginPatterns.add("*");
//        corsConfiguration.setAllowedOriginPatterns(allowedOriginPatterns);
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//
//        return corsConfiguration;
//    }



    /**
     * Function:Tomcat 默认拦截特殊字符
     * Author: Admin
     * Date:2021/6/26
     * @param
     * @return org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
     * @throws Exception
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "|{}[]"));

        return factory;
    }

    /**
     * 功能: 映射静态资源
     * 作者: chenlei
     * 创建日期:2021/10/9
     * 参数:[registry]
     * 返回:void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FoundationConstant.RESOURCE_URL_PREFIX + "**").addResourceLocations("file:"+ FileConfig.getFileRootDirectory());
    }


//所有上行 parameter or form data or json data all param ok ""=>null
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(String.class, new Formatter<String>() {
            @Override
            public String print(String text, Locale locale) {
                return StringUtils.trimToNull(text);
            }

            @Override
            public String parse(String text, Locale locale) {
                return StringUtils.trimToNull(text);
            }
        });
    }
    /**
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //@responseBody: 不序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        // 序列化
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN)));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)));
        // 反序列化
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN)));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)));
        javaTimeModule.addDeserializer(String.class, new BlankStringToNull(String.class));
        objectMapper.registerModule(javaTimeModule);

//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addDeserializer(String.class, new BlankStringToNull(String.class));
//        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }
   // json请求参数：属性值 ""=>null
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // 仅适用实体类型的对象参数
//        converters.add(mappingJackson2HttpMessageConverter());
//    }
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addDeserializer(String.class, new BlankStringToNull(String.class));
//
//        ObjectMapper mapper = new ObjectMapper();
//        //未知属性是否报错
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.registerModule(simpleModule);
//
//        //防止日期转成时间戳：1630463093355
//        //或使用注解 @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//
//        converter.setObjectMapper(mapper);
//
//        return converter;
//    }

    private static class BlankStringToNull extends StdDeserializer<String> {

        private static final long serialVersionUID = 7095734746386292457L;

        protected BlankStringToNull(Class<String> vc) {
            super(vc);
        }

        @Override
        public String deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            return StringUtils.trimToNull(parser.getText());
        }
    }

}
