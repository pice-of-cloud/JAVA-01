package io.lvxy.demo.starter.service;

import io.lvxy.demo.starter.properties.Klass;
import io.lvxy.demo.starter.properties.School;
import io.lvxy.demo.starter.properties.Student;

public class DemoService {
    public String sutndentName;
    public String className;

    public DemoService(String sutndentName, String className){
         this.className = className;
         this.sutndentName = sutndentName;
     }


    public String say(){
         return this.sutndentName + "!  in " + className;
    }


}
