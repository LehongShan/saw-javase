package cn.shan.saw.javase.comparable;

import lombok.Data;
import lombok.ToString;

/**
 * Created by shanlehong on 2017/4/5.
 */
@Data
@ToString
public class Student1 {
    private String name;        // 姓名
    private int age;            // 年龄

    public Student1(String name,int age){
        this.name = name;
        this.age = age;

    }
}
