package cn.shan.saw.javase.algorithm.myselftest;


import cn.shan.saw.javase.algorithm.sort.BaseSort;

/**
 * 排序练习
 * Created by shanlehong on 2017/12/19.
 */
public class SortExercise extends BaseSort {

    public static void executeBubbleSort(){
        int size = scoreArr.length;
        for (int i = 0;i<size-1;i++){
            boolean flag = true; //交换标识
            for (int j=0;j<size-i-1;j++){
                if (scoreArr[j]>scoreArr[j+1]){
                    int temp = scoreArr[j+1];
                    scoreArr[j+1] = scoreArr[j];
                    scoreArr[j] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        System.out.println("\n冒泡排序开始");
        print();
        System.out.println("\n冒泡排序结束");
    }

    /**
     * 插入排序关键 找到本次最小的值的索引
     */
    public static void executeSearchSort(){
        int size = scoreArr.length;
        for (int i=0;i<size-1;i++){
            int min = i;
            int j = i+1;
            while(j<size){
                if (scoreArr[min]> scoreArr[j]){
                    min = j;
                }
                j++;
            }

           if (min!=i){
                int tmp = scoreArr[min];
                scoreArr[min] = scoreArr[i];
                scoreArr[i] = tmp;
           }
        }
        System.out.println("\n选择排序开始");
        print();
        System.out.println("\n选择排序结束");
    }

    public static void executeInsertSort() {
        int size = scoreArr.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            int target = scoreArr[i];
            while (j > 0 && scoreArr[j - 1] > target) {
                scoreArr[j] = scoreArr[j - 1];
                j--;
            }
            scoreArr[j] = target;
        }
        System.out.println("\n直接插入排序开始");
        print();
        System.out.println("\n直接插入排序结束");
    }

    public static void executeBinaryInsertSort(){

        int size = scoreArr.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            int target = scoreArr[i];
            int low = 0;
            int high = i;
            while (low<=high){
                int middle = (low+high)/2;
                if (scoreArr[middle]>target){
                    high = middle-1;
                }else {
                    low = middle +1;
                }
            }
            while (j > low) {
                scoreArr[j] = scoreArr[j - 1];
                j--;
            }
            scoreArr[j] = target;
        }
        System.out.println("\n折半插入排序开始");
        print();
        System.out.println("\n折半插入排序结束");
    }

    public static void executeQuickSort(){
        quickSort(scoreArr,0,scoreArr.length-1);
        System.out.println("\n快速排序开始");
        print();
        System.out.println("\n快速排序结束");
    }

    private static void quickSort(int [] a,int low ,int high){
        int start = low;
        int end = high;
        int key = a[low];

        while (start < end){


            while(start<end && a[end]>=key){
                end--;
            }
            if (a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }

            while (start<end && a[start]<=key){
                start++;
            }
            if (a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }




            if (start>low) quickSort(a,low,start-1);

            if (end<high) quickSort(a,end+1,high);

        }


    }


}
