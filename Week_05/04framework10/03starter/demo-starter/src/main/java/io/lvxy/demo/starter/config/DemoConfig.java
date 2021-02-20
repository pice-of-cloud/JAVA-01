package io.lvxy.demo.starter.config;

import io.lvxy.demo.starter.properties.Klass;
import io.lvxy.demo.starter.properties.School;
import io.lvxy.demo.starter.properties.Student;
import io.lvxy.demo.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({Student.class, School.class, Klass.class})
public class DemoConfig {

    @Autowired
    private Student student;
    @Autowired
    private Klass klass;
    @Autowired
    private School school;


    public String getExamInfo() {
        return this.school.toString() + "----" + this.klass.toString() + "----" + student.toString();
    }

    @Bean(name = "exam")
    public DemoService demoService(){
        return new DemoService(student.getName(), klass.getClassName());
    }

}
