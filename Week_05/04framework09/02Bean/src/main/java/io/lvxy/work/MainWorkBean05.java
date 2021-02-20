package io.lvxy.work;

import io.lvxy.beans.comp.Bean04;
import io.lvxy.beans.comp.Bean05;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWorkBean05 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean05 bean05 = context.getBean(Bean05.class);
        bean05.say("bean05、、、、、、、");
    }
}
