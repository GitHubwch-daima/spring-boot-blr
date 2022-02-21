package com.azure.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MyAspectConfig {

    @Before(value = "execution(* com.azure.service.*.*(..))")//方法级别
    public void before(JoinPoint joinPoint) {
        System.out.println("=======aop-before=======");
        System.out.println("before输出执行的类：" + joinPoint.getTarget());
        System.out.println("before输出执行的方法名：" + joinPoint.getSignature().getName());
    }

    @After(value = "within(com.azure.service.impl.*)")//类级别
    public void after(JoinPoint joinPoint) {
        System.out.println("After输出执行的类：" + joinPoint.getTarget());
        System.out.println("After输出执行的方法名：" + joinPoint.getSignature().getName());
        System.out.println("=======aop-after=======");
    }

    @Around(value = "@annotation(com.azure.annotations.MyAdvice)")//基于注解生效
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("=======aop-around-前置=======");
        System.out.println("Around输出执行的类：" + proceedingJoinPoint.getTarget());
        System.out.println("Around输出执行的方法名：" + proceedingJoinPoint.getSignature().getName());
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("=======aop-around-后置=======");
        return proceed;
    }

}
