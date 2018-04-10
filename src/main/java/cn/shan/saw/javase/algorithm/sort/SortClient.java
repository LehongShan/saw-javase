package cn.shan.saw.javase.algorithm.sort;

import org.junit.Test;

/**
 * 排序触发客户端
 * Created by shanlehong on 2017/12/12.
 *
 */
public class SortClient {

    @Test
    public void testBubbleSort() {
        BaseSort.print();
        BubbleSort.sort();
    }
    @Test
    public void testQuickSort(){
        BaseSort.print();
        QuickSort.sort();
    }
    @Test
    public void testSearchSort() {
        BaseSort.print();
        SearchSort.sort();

    }
    @Test
    public void testSearchSort2() {
        BaseSort.print();
        SearchSort.sort2();

    }
    @Test
    public void testInsertSort() {
        BaseSort.print();
        InsertSort.sort();

    }
    @Test
    public void testBinaryInsertSort() {
        BaseSort.print();
        BinaryInsertSort.sort();
    }

    @Test
    public void testMergeSort() {
        BaseSort.print();
        MergeSort.sort();
    }
}
