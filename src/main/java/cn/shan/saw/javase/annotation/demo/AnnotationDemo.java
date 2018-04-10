package cn.shan.saw.javase.annotation.demo;

import cn.shan.saw.javase.annotation.MyTag;
import cn.shan.saw.javase.annotation.vo.Car;
import lombok.Data;
import lombok.ToString;

/**
 * Created by shanlehong on 2017/5/8.
 */
@Data
@ToString
public class AnnotationDemo {
    @MyTag(name = "audi",size =10)
    private Car car;
}
