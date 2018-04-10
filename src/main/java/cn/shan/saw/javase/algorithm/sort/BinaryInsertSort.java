package cn.shan.saw.javase.algorithm.sort;

/**
 * 折半插入排序
 * Created by shanlehong on 2017/12/13.
 */
public class BinaryInsertSort  extends BaseSort{

    public static void sort(){
        int size = scoreArr.length;

        for (int i=1;i<size;i++){
            int target = scoreArr[i];
            int low =0;
            int high =  i-1;
            int j = i;
            while(low<=high){
                int middle = (low+high)/2;
                if (scoreArr[middle]<target){
                    low = middle+1;
                }else {
                    high = middle-1;
                }
            }
            while(j>low){
                scoreArr[j] = scoreArr[j-1];
                j--;
            }
            scoreArr[low]=target;
        }
        System.out.println("\n折半插入排序开始");
        print();
        System.out.println("\n折半插入排序结束");
    }


}
