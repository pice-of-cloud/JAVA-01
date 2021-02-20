package io.lvxy.app;

import io.lvxy.aop.Hello;
import io.lvxy.aop.Msg;
import io.lvxy.aop1.Notice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.jvm.hotspot.HelloWorld;

public class AopWork {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

       /* Hello hello = context.getBean(Hello.class);
        hello.sayHello("helloBean=");
        System.out.println();


        Hello hello1 = new Hello();
        hello1.sayHello("new Hello=");
        System.out.println();*/

        System.out.println("~~~~~~~~~~~~~~~~~context.getBean(Msg.class)");
        Msg msg = context.getBean(Msg.class);
        System.out.println("msg:"+msg);
        System.out.println("mst.toString:"+msg.toString());
        msg.addMsg();
        //System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~context.getBean(Msg.class)");
        System.out.println();


        Notice notice = context.getBean(Notice.class);

        System.out.println(notice);
        System.out.println(notice.toString());

        notice.readNotice();
        System.out.println();
        notice.writeNotice();
    }
}
