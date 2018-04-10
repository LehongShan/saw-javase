package cn.shan.saw.javase.datastructure.map;

import cn.shan.saw.javase.comparable.Student;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by shanlehong on 2017/4/5.
 */
public class TestTreeMap {
    Set<Student> set;

    @Test
    public void testSort(){
        init();
        for(Student stu : set) {
            System.out.println(stu);
        }

    }

    void init(){

        set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));



    }


}
