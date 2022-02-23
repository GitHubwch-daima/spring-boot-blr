package com.azure;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootJasyptApplicationTests {


    @Resource
    private StringEncryptor stringEncryptor;

    @Test
    void contextLoads() {
        //wAze6SY4WodtsxPsVrAmnRw+2rK34g0J+jEJh6//++Fj215jS36KbUaX8yZvNRoe
        //0FyEvUMKgGHPytA7JaUSo6R0Dep4w6V54EWnxKyFzM488X7nEHxuIBr3B2L5/DS7
        String root = stringEncryptor.encrypt("");
        System.out.println(root);

//        System.out.println(stringEncryptor.decrypt("0FyEvUMKgGHPytA7JaUSo6R0Dep4w6V54EWnxKyFzM488X7nEHxuIBr3B2L5/DS7"));
    }

}
