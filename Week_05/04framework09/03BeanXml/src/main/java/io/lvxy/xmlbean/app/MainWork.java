package io.lvxy.xmlbean.app;

import io.lvxy.xmlbean.ISchool;
import io.lvxy.xmlbean.beans.Klass;
import io.lvxy.xmlbean.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWork {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student01 = (Student) context.getBean("student01");
        System.out.println(student01);
        System.out.println();

        Student student04 = (Student) context.getBean("student04");
        System.out.println(student04);
        System.out.println();

        Klass klass01 = (Klass) context.getBean("klass02");
        System.out.println(klass01);
        System.out.println();

        ISchool school01 = (ISchool) context.getBean("school01");
        System.out.println(school01);
        System.out.println();

        ISchool school02 = (ISchool) context.getBean("school02");
        System.out.println(school02);
        System.out.println();



        System.out.println("context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));
    }
}
