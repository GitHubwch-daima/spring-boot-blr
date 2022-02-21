package com.azure.config;

import com.azure.interceptors.MyInterceptor1;
import com.azure.interceptors.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1())//指定拦截器
                .addPathPatterns("/**")//拦截所有
                .excludePathPatterns("/file/*","/errorPage")//排除路径
                .order(1);//执行顺序

/*        registry.addInterceptor(new MyInterceptor2())//指定拦截器
                .addPathPatterns("/**")//拦截所有
                .excludePathPatterns("/file/*")//排除路径
                .order(2);//执行顺序*/
        //顺序：1、4、5、2、6、3，拦截器栈
    }
}
