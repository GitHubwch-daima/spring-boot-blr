package com.azure.controller;

import com.azure.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("test")
public class ThymeleafController {

    @RequestMapping("thymeleaf")
    public String test(HttpServletRequest request, Model model, HttpSession session) {
        //传递单个值
        request.setAttribute("testName", "azure");
        model.addAttribute("testAge", 22);
        model.addAttribute("baidu", "<a href='https://www.baidu.com'>baidu</a>");

        //传递对象
        User user = new User(1, "azure", new Date());
        model.addAttribute("user", user);
        List<User> list = Arrays.asList(
                new User(1, "test1", new Date()),
                new User(2, "test2", new Date()),
                new User(3, "test3", new Date()));
        model.addAttribute("userList", list);

        session.setAttribute("sessionKey", "sessionData");
        return "index";
    }
}
