package com.azure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionResolver {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);


    @ExceptionHandler(value = Exception.class)//全部处理(作用在方法上，用来处理指定的异常)
    @ResponseBody//结果转为json
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        log.debug("自定义异常处理：" + ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = UserNameNotFoundException.class)//处理自定义异常(作用在方法上，用来处理指定的异常)
    @ResponseBody
    public ResponseEntity<String> UserNameNotFoundHandler(Exception ex) {
        log.debug("自定义异常处理：" + ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
