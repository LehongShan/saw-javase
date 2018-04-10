package cn.shan.saw.javase.algorithm.sort;

/**
 * 快速排序
 * Created by shanlehong on 2017/12/12.
 */
public class QuickSort extends BaseSort {

    public static void  sort(){

        sort(scoreArr,0,scoreArr.length-1);
        System.out.println("\n快速排序开始");
        print();
        System.out.println("\n快速排序结束");

    }

    private static void sort(int [] arr,int low,int high){
        int start = low;
        int end = high;
        int key = arr[low];
        while(end > start){
            while (end > start && key <= arr[end]) {
                end--;
            }
            if (key>=arr[end]){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }

            while(end>start && key>=arr[start]){
                start++;
            }
            if (key<=arr[start]){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //以上排序确保关键值右边的数据比关键值大 左边的数据比关键值小
            if (start>low) {
                sort(arr,low,start-1);
            }
            if (end<high) {
                sort(arr,end+1,high);
            }
        }

    }


}
