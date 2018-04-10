package cn.shan.saw.javase.annotation;

import javax.annotation.Resource;
import java.lang.annotation.*;

/**
 * Created by shanlehong on 2017/5/8.
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTag {
    String name() default "车";
    int size() default  10;
}
