package io.lvxy.work;

import io.lvxy.beans.Bean07;
import io.lvxy.beans.comp.Bean04;
import io.lvxy.beans.comp.Bean08;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean08 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean08.xml");
        //Bean04 bean04 = context.getBean(Bean04.class);
        //System.out.println(bean04);
        Bean08 bean08 = context.getBean(Bean08.class);
        System.out.println(bean08);
    }
}
