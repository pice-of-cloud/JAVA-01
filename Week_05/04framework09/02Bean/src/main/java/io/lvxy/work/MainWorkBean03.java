package io.lvxy.work;

import io.lvxy.beans.Bean02;
import io.lvxy.beans.Bean03;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean03 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean03 bean03 = context.getBean(Bean03.class);

    }
}
