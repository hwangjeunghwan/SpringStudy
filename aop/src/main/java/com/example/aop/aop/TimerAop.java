package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component //컴포넌트 클래스단위 bean 메소드 단위 컨피그레이션 하나의 클래스에 여러가지 빈
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void Cut(){

    }
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){

    }

    @Around("Cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object = joinPoint.proceed();
        stopWatch.stop();

        System.out.println("total time : "+ stopWatch.getTotalTimeSeconds());
    }


}
