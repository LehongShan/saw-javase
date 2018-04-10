package cn.shan.saw.javase.algorithm.sort;

/**
 * 归并算法
 * Created by shanlehong on 2017/12/14.
 */
public class MergeSort extends BaseSort {

    public static void sort(){
        mergeSort(scoreArr,0,scoreArr.length-1);
        System.out.println("\n归并排序开始");
        print();
        System.out.println("\n归并排序结束");

    }

    private static void mergeSort(int [] a,int left,int right){

        if (left<right){
            //找出中间索引
            int center = (left+right)/2;
            //对左边数组递归
            mergeSort(a,left,center);
            //对右边数组递归
            mergeSort(a,center+1,right);
            //合并
            merge(a,left,center,right);
        }

    }

    /**
     * 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
     * @param a 数组对象
     * @param left 左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1 为右数组的第一个元素的索引
     * @param right 右数组的最后一个元素的索引
     */
    private static void merge(int [] a,int left,int center,int right){
        int [] temp = new int[a.length];
        int middle = center +1;
        //记录中间数组的索引
        int thirdIndex = left;
        int tempIndex = left;
        while (left<=center && middle<=right){
            //从两个数组中取出小的放入中间数组
            if (a[left]<= a[middle]){
                temp[thirdIndex++] = a[left++];
            }else {
                temp[thirdIndex++] = a[middle++];
            }
        }
        //剩余部分依次放入中间数组
        while(middle<=right){
            temp[thirdIndex++] = a[middle++];
        }
        while (left<=center){
            temp[thirdIndex++] = a[left++];
        }
        //将中间数组中的内容复制拷回原数组
        //(原left-right范围的内容被复制回原数组)
        while(tempIndex<=right){
            a[tempIndex] = temp[tempIndex++];
        }

    }

}
