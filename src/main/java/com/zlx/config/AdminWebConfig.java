package com.zlx.config;

import com.zlx.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addInterceptor:把拦截器注册
         * addPathPatterns:添加要拦截的资源，/**表示拦截所有也会拦截静态资源
         * excludePathPatterns：排除不要拦截的资源
         */
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login","/userLogin","/css/**","/dist/**","/layui/**","/lib/**", "/api/**", "/images/**", "/js/**", "/sql");

    }
}
