package io.lvxy.aop1;

import io.lvxy.aop.Msg;
import lombok.Data;

@Data
public class MyMsg implements Msg {
    @Override
    public void addMsg() {
        System.out.println("`````````````````````````````this is msg `````````````````````````");
    }
}
