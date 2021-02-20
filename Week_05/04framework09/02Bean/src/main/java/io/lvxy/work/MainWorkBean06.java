package io.lvxy.work;

import io.lvxy.beans.Bean06;
import io.lvxy.beans.comp.Bean05;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean06 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean06.xml");
        Bean06 bean06 = context.getBean(Bean06.class);
        System.out.println(bean06);
    }
}
