package cn.shan.saw.javase.algorithm.myselftest;

import cn.shan.saw.javase.algorithm.sort.BaseSort;
import org.junit.Test;

/**
 * 自我练习客户端
 * Created by shanlehong on 2017/12/19.
 */
public class SortExerciseClient {

    @Test
    public void testBubbleSort(){
        BaseSort.print();
        SortExercise.executeBubbleSort();
    }

    @Test
    public void testSearchSort(){
        BaseSort.print();
        SortExercise.executeSearchSort();
    }

    @Test
    public void testInsertSort(){
        BaseSort.print();
        SortExercise.executeInsertSort();
    }

    @Test
    public void testBinaryInsertSort(){
        BaseSort.print();
        SortExercise.executeBinaryInsertSort();
    }


    @Test
    public void testQuickSort(){
        BaseSort.print();
        SortExercise.executeQuickSort();
    }
}
