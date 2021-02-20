package io.lvxy.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Data
public class Bean07 {
    private String name;

    @Autowired
    private Bean01 bean01;

    @Autowired
    private Bean02 bean02;

    public Bean07(){
        this.name = "bean007";
    }
    public void sayHello(){
        System.out.println("this is bean07 sayHello ~~~~~");
    }
}
