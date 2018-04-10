package cn.shan.saw.javase.algorithm.sort;

/**
 * 选择排序
 * Created by shanlehong on 2017/12/13.
 */
public class SearchSort extends BaseSort {

    public static void sort(){
        int size = scoreArr.length;
        for (int i=0;i<size-1;i++){
            //优化前，一旦发现内层循环有比scoreArr[i]小的元素就做一次交换增加交换次数
            for (int j = i+1;j<size;j++){
                if (scoreArr[i]>scoreArr[j]){
                    int temp = scoreArr[j];
                    scoreArr[j] = scoreArr[i];
                    scoreArr[i] = temp;
                }
            }
        }
        System.out.println("\n直接选择排序开始");
        print();
        System.out.println("\n直接选择排序结束");
    }

    public static void sort2(){
        int size = scoreArr.length;
        for (int i=0;i<size-1;i++){
            int minIndex = i;
            //优化后的方案是内层循环只需要找到比scoreArr[i]要小的数据元素记录下标
            for (int j = i+1;j<size;j++){
                if (scoreArr[minIndex]>scoreArr[j]){
                    minIndex = j;
                }

            }
            //出内层循环时候再做判断最小元素的小标是否改变
            if (minIndex!=i){
                int temp = scoreArr[minIndex];
                scoreArr[minIndex] = scoreArr[i];
                scoreArr[i] = temp;

            }

        }
        System.out.println("\n直接选择排序优化开始");
        print();
        System.out.println("\n直接选择排序优化结束");
    }

}
