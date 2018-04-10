package cn.shan.saw.javase.annotation;


import cn.shan.saw.javase.annotation.demo.AnnotationDemo;
import cn.shan.saw.javase.annotation.vo.Car;

import java.lang.reflect.Field;

/**
 * Created by shanlehong on 2017/5/8.
 */
public class AnnotationProccessor {

    public static void annProcess(AnnotationDemo annotationDemo){

        for (Field field:annotationDemo.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(MyTag.class)){
                MyTag myTag = field.getAnnotation(MyTag.class);
                annotationDemo.setCar(new Car(myTag.name(),myTag.size()));
            }
        }
    }

    public static void main(String [] args){
        AnnotationDemo ann = new AnnotationDemo();
        annProcess(ann);
        System.out.println(ann.getCar());
    }
}
