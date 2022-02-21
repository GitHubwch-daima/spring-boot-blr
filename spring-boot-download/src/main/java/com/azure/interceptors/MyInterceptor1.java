package com.azure.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyInterceptor1.class);

    //最先执行
    //参数3：handler当前请求的控制器方法对象
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("handler：{}", handler);
        log.debug("=======1-preHandle=======");
        response.sendRedirect(request.getContextPath() + "/errorPage");
        return false;
    }

    //参数4：模型和视图 当前请求方法的ModelAndView对象
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("=======2-postHandle=======");
    }

    //参数4：控制器出现异常时的异常对象
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("=======3-afterCompletion=======");
    }
}
