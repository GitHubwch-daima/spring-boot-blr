package com.azure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);


    /**
     * 当控制器中任意一个方法出现异常时，如果控制器没有自己的try catch，则会进入此方法
     *
     * @param request  当前请求对象
     * @param response 当前请求响应对象
     * @param handler  错误出现的方法对象
     * @param ex       出现异常的异常对象
     * @return 模型和视图
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.debug("GlobalExceptionResolver 全局异常处理");
        log.debug("当前异常为：" + ex);
        ModelAndView modelAndView = new ModelAndView();
        //针对不同类型跳转不同页面
        if (ex instanceof UserNameNotFoundException) {
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }
        modelAndView.setViewName("500Page");
        return modelAndView;
    }
}
