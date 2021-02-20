package io.lvxy.beans.comp;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(value = "singleton")
public class Bean04 {

    private int age = 0;

    public Bean04(){
        this.age = 4;
        System.out.println("I am constructor bean04");
    }
    public void say(String hi){
        System.out.println("this is bean04 say hi="+hi);
    }
}
