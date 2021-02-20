package io.lvxy.beans;

import lombok.Data;

@Data
public class Bean03 {

    public Bean03(){
        System.out.println("this is bean03 constructor");
    }

    public Bean03(String hi){
        System.out.println("this is bean03 constructor with param hi = "+hi);
    }

    public void say(){
        System.out.println("this is bean03 say~~~init-method");
    }

}
