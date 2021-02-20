package io.lvxy.work;

import io.lvxy.beans.Bean01;
import io.lvxy.beans.Bean02;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean02 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean02 bean02 = context.getBean(Bean02.class);

    }
}
