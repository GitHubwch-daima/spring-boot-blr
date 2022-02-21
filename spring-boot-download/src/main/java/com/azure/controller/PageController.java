package com.azure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 下载测试页面
     *
     * @return
     */
    @RequestMapping("page")
    public String downloadPage() {
        return "downloadPage";
    }

    /**
     * 拦截器测试页面
     *
     * @return
     */
    @RequestMapping("interceptor")
    public String interceptorPage() {
        return "interceptorPage";
    }

    /**
     * 错误页面
     *
     * @return
     */
    @RequestMapping("errorPage")
    public String errorPage() {
        return "errorPage";
    }
}
