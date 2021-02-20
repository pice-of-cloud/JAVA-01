package io.lvxy.beans.comp;

import io.lvxy.beans.Bean01;
import io.lvxy.beans.Bean02;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Data
@Component
@Scope(value = "singleton")
public class Bean08 {
    private String name;

    @Resource
    private Bean04 bean04;


    public Bean08(Bean04 bean04){
        this.bean04 = bean04;
    }


    public Bean08(){
        this.name = "I am bean08888";
    }
    public void sayHello(){
        System.out.println("this is bean08 sayHello ~~~~~");
    }
}
