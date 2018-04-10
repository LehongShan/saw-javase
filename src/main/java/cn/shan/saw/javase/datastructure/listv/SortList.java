package cn.shan.saw.javase.datastructure.listv;

import cn.shan.saw.javase.comparable.Student1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanlehong on 2017/4/5.
 */
public class SortList {
    List<Student1>  student1s;

    @Test
    public void testSortList(){
        init();


    }

    void init(){

        student1s = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        student1s.add(new Student1("Hao LUO", 33));
        student1s.add(new Student1("XJ WANG", 32));
        student1s.add(new Student1("Bruce LEE", 60));
        student1s.add(new Student1("Bob YANG", 22));



    }


}
