package me.whiteship;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited //상속이 되는 어노테이션이다 라는 뜻
public @interface AnotherAnnotation {

    String name() default "yeonsang";
//    String value() default "yeonsang";

    int number() default 100;
}
