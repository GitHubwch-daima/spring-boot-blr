package com.azure;

import com.azure.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootAopApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads1() {
        String userName = userService.selectUser("azure");
        System.out.println("返回值：" + userName);
    }

    @Test
    void contextLoads2() {
        userService.insertUser();
    }


}
