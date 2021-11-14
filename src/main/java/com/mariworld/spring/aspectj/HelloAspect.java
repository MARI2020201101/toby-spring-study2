package com.mariworld.spring.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

@Aspect
@Slf4j
@Component
public class HelloAspect {
    @Before("all()")
    public void printHello(JoinPoint joinPoint) throws Throwable {
        log.info("hello------------------------------------");
        String name = joinPoint.getSignature().getName();
        log.info(name);
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        log.info(declaringType.toString());

    }

    @Around("all()")
    public Object printHello(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("hello------------------------------------");
        Object proceed = joinPoint.proceed();
        return proceed;
    }

    @Pointcut("execution(* *(..))")
    private void all(){

    }
}
