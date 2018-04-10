package cn.shan.saw.javase.algorithm.sort;

/**
 * 插入排序
 * Created by shanlehong on 2017/12/13.
 */
public class InsertSort extends BaseSort{

    public static void sort(){
        int size = scoreArr.length;
        for (int i =1;i<size;i++){
          int target = scoreArr[i];
          int j = i;
          while(j>0 && scoreArr[j-1]>target){
              scoreArr[j] = scoreArr[j-1];
              j--;
          }
            scoreArr[j] = target;
        }
        System.out.println("\n直接插入排序开始");
        print();
        System.out.println("\n直接插入排序结束");
    }
}
