package io.lvxy.demo.starter.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "klass")
public class Klass {

    List<Student> students;

    @Value("clsssOne")
    private String className;

    public void startExam() {
        System.out.println("start exam");
    }

}
