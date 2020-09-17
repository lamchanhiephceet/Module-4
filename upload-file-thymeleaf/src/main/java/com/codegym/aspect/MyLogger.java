package com.codegym.c0320h1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyLogger {

    @AfterReturning(pointcut = "within(com.codegym.c0320h1.controller.*)", returning = "result")
    public void log(JoinPoint joinPoint, Object result){
        System.out.println("Start log");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "." + methodName);
        if(result == null){
            System.out.println("null");
        }
        else {
            System.out.println(result.hashCode());
        }
    }

}
