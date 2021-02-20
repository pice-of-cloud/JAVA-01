package io.lvxy.xmlbean.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Klass {
    List<Student> students;

    private String className;

    public void startExam(){
        System.out.println("start exam");
    }

}
