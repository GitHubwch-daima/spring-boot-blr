package com.azure.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin解决局部跨域问题，只能写在类上
@RestController
public class CorsController {

    /**
     * Access to XMLHttpRequest
     *
     * @return
     */
    @RequestMapping("/demo")
    public String demo() {
        return "demo is ok!";
    }
}
