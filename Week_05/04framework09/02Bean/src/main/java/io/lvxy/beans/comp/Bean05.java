package io.lvxy.beans.comp;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component
@Scope(value = "singleton")
public class Bean05 {

    @Resource
    private Bean04 bean04;

    public void say(String hi){
        System.out.println("this is bean05 say hi="+hi);
        bean04.say("I am bean04, I am in Bean05!!!");
    }
}
