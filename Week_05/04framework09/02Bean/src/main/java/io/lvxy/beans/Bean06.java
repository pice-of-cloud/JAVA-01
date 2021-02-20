package io.lvxy.beans;

import lombok.Data;

@Data
public class Bean06 {

    private Bean01 bean01;
    private Bean02 bean02;

    public Bean06(){
        System.out.println("this is bean06 constructor");
    }

    public Bean06(String hi){
        System.out.println("this is bean067 constructor with param hi = "+hi);
    }

}
