package io.lvxy.demo.starter.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student implements Serializable {

    @Value("10000000")
    private int no;

    @Value("grade00001")
    private String grade;

    @Value("student111111")
    private String name;
}
