package io.lvxy.beans;

import lombok.Data;

@Data
public class Bean01 {
    private String name;

    public void sayHello(){
        System.out.println("this is WorkBean01 sayHello ~~~~~");
    }
}
