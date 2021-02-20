package io.lvxy.xmlbean.beans;

import io.lvxy.xmlbean.ISchool;
import lombok.Data;

import java.util.List;

@Data
public class School implements ISchool {
    private String schoolName;

    List<Klass> klasses;

    @Override
    public void exam() {
        System.out.println("this is exam.");
    }
}
