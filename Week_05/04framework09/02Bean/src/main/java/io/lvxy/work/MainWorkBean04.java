package io.lvxy.work;

import io.lvxy.beans.Bean03;
import io.lvxy.beans.comp.Bean04;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean04 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean04 bean04 = context.getBean(Bean04.class);
        bean04.say("bean04~~");
    }
}
