package com.azure.controller;

import com.azure.exception.UserNameNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @RequestMapping("test1")
    public String testException1(Integer id) {
        log.debug("id====>{}", id);
        int i = id / 0;
        return "redirect:index";
    }

    @RequestMapping("test2")
    public String testException2(Integer id) {
        log.debug("id====>{}", id);
        if (id > 0) {
            return "redirect:index";
        } else {
            throw new UserNameNotFoundException("test2用户名不能小于0");
        }
    }
}
