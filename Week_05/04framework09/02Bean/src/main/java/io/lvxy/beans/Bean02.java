package io.lvxy.beans;

import lombok.Data;

@Data
public class Bean02 {

    private int age;
    private String location;

    public Bean02(){
        System.out.println("this is Bean02 constructor");
    }

    public Bean02(String hi){
        System.out.println("this is constructor bean02 with param hi = "+hi);
    }

}
