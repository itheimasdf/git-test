package com.itheima.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyServiceAspect {

    public Object aa(ProceedingJoinPoint joinPoint){

        long begin = System.currentTimeMillis();
        System.out.println("begin...");

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("end...");
        long end = System.currentTimeMillis();
        System.out.println("执行耗时"+joinPoint+"|"+(end-begin)+"毫秒");
        return proceed;
    }
}
