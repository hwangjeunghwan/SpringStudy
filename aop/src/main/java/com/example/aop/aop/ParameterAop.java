package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //aop동작
@Component //스프링관리
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void Cut(){

    }
    @Before("Cut()" )
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());


        Object[] args = joinPoint.getArgs();


        for(Object obj : args){
            System.out.println("method : " +obj.getClass().getSimpleName());
            System.out.println("value : " +obj);
        }
    }
    @AfterReturning(value = "Cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("returnobj");
        System.out.println(returnObj);
    }
}
