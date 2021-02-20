package io.lvxy.aop1;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aop1 {
    
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("aop1-----------------hello test aronud before !");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("aop1-----------------hello test around after !");
    }


    public void beforeSay(){
        System.out.println("aop1-----beforeSay-------this is before ---");
    }

    public void afterSay(){
        System.out.println("aop1------afterSay----------this is a after returning ---");
    }
}
