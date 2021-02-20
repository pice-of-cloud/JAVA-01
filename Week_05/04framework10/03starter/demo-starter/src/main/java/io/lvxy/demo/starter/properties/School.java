package io.lvxy.demo.starter.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "school001")
public class School implements ISchool {

    @Value("geek")
    private String schoolName;

    //List<Klass> klasses;

    @Override
    public void exam() {
        System.out.println("this is exam.");
    }
}
