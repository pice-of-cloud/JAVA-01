package io.lvxy.work;

import io.lvxy.beans.Bean01;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean01 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean01 bean01 = context.getBean(Bean01.class);
        bean01.sayHello();
    }
}
