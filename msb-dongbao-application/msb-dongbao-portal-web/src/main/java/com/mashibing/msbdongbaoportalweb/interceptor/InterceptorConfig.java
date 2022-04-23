package com.mashibing.msbdongbaoportalweb.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-20 22:09
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }
    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(authInterceptor())
                    .addPathPatterns("/**")//拦截哪些
                    .excludePathPatterns("/ums-member/in")
            .excludePathPatterns("/ums-member/byName")
            .excludePathPatterns("/**");//哪些不拦截
    }
}
