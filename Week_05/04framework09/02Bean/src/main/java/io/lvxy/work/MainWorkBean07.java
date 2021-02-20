package io.lvxy.work;

import io.lvxy.beans.Bean06;
import io.lvxy.beans.Bean07;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean07 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean07.xml");
        Bean07 bean07 = context.getBean(Bean07.class);
        System.out.println(bean07);
    }
}
