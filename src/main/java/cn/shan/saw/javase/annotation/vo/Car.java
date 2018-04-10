package cn.shan.saw.javase.annotation.vo;

import lombok.Data;
import lombok.ToString;

/**
 * Created by shanlehong on 2017/5/8.
 */
@Data
@ToString
public class Car {

    private String name;
    private int size;

    public Car(String name, int size){
        this.size = size;
        this.name = name;
    }
}
