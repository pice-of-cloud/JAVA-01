package io.lvxy.v1.aop;

import io.lvxy.v1.bean.DataBaseContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(io.lvxy.v1.config.database.Master) " +
            "&& (execution(* io.lvxy.v1.service..*.select*(..)) " +
            "|| execution(* io.lvxy.v1.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(io.lvxy.v1.config.database.Master) " +
            "|| execution(* io.lvxy.v1.service..*.insert*(..)) " +
            "|| execution(* io.lvxy.v1.service..*.add*(..)) " +
            "|| execution(* io.lvxy.v1.service..*.update*(..)) " +
            "|| execution(* io.lvxy.v1.service..*.edit*(..)) " +
            "|| execution(* io.lvxy.v1.service..*.delete*(..)) " +
            "|| execution(* io.lvxy.v1.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DataBaseContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DataBaseContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* io.lvxy.v1.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}