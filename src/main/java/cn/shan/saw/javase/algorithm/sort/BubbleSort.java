package cn.shan.saw.javase.algorithm.sort;

/**
 * 冒泡排序
 * Created by shanlehong on 2017/12/12.
 */
public class BubbleSort extends BaseSort {


   public  static  void sort(){
       int size = scoreArr.length;
       int k = size -1, pos = 0;

       for (int i = 0; i<size-1;i++){
           boolean flag = true;
           for (int j =0;j<k;j++){
               if (scoreArr[j]>scoreArr[j+1]){
                   int temp = scoreArr[j];
                   scoreArr[j] = scoreArr[j+1];
                   scoreArr[j+1] = temp;
                   flag = false;
                   pos = j;
               }
           }
           k=pos;
           if (flag){
               break;
           }
       }
       System.out.println("\n冒泡排序开始");
       print();
       System.out.println("\n冒泡排序结束");

   }


}
