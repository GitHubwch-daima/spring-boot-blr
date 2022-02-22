package com.azure.controller;

import com.azure.exception.UserNameNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping
    public ResponseEntity<String> demo() {
        log.debug("demo is ok");
        int i = 5 / 0;
        return new ResponseEntity<>("demo is ok", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> demo(@PathVariable("id") Integer id) {
        log.debug("demo is ok");
        if (id > 0) {
            return new ResponseEntity<>("demo is ok", HttpStatus.OK);
        } else {
            throw new UserNameNotFoundException("123456异常！");
        }
    }
}
