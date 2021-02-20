package io.lvxy.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.annotation.PostConstruct;

@Aspect
public class Aop2 {

    @Pointcut(value = "execution(* io.lvxy.*.Notice.readNotice(..))")
    //@Pointcut(value ="execution(* io.lvxy.aop1.*.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(){
        System.out.println("this is aop2 before..............");
    }

    @After(value = "pointCut()")
    public void after(){
        System.out.println("this is aop2 after=============");
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("this is aop2 around ----------before~~~~");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("this is aop2 around ----------after~~~~~~");
    }


}
