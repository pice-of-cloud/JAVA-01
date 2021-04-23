package io.lvxy.v1.config.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})//该注解应用在方法上
@Retention(RetentionPolicy.RUNTIME)//在运行时运行
public @interface Master {
}
