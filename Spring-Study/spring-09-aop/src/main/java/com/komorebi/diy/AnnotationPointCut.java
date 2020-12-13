package com.komorebi.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 方式三：使用注解方式实现
@Aspect     // 标注一个类是切面
public class AnnotationPointCut {
    @Before("execution(* com.komorebi.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("Before the method");
    }

    @After("execution(* com.komorebi.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("After the method");
    }

    @Around("execution(* com.komorebi.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("before around");
        Object proceed = jp.proceed();              // 执行方法
        System.out.println("after around");
    }
}
