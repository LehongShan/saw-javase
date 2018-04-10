package cn.shan.saw.javase.datastructure.queue;

import java.util.Arrays;

/**
 * 顺序队列
 * Created by shanlehong on 2017/12/18.
 */
public class SequenceQueue<T> {
    private int DEFAULT_SIZE = 2;
    //保存数组的长度
    private int capacity;
    //定义个数组用于保存顺序栈的元素
    private Object[] elementsData;

    private int front;
    private int rear;

    public SequenceQueue(){
        capacity = DEFAULT_SIZE;
        elementsData = new Object[capacity];
    }
    public SequenceQueue(T element){
        this();
        elementsData[0] = element;
        rear++;
    }

    public SequenceQueue(T element,int size){
        capacity = size;
        elementsData = new Object[capacity];
        elementsData[0] = element;
        rear++;
    }

    public void add(T element){
        if (rear>capacity-1){
            throw new IndexOutOfBoundsException("队列已满");
        }
        elementsData[rear++] = element;
    }

    public T remove(){
        if (empty()){
           return null;
        }
        T oldValue =  (T) elementsData[front];
        elementsData[front++] = null;
        return oldValue;
    }
    public T element(){
        if (empty()) return null;

        return (T) elementsData[rear];
    }

    public boolean empty(){
        return rear-front == 0;
    }
    //清空队列
    public void  clear(){
        Arrays.fill(elementsData,null);
        this.front = 0;
        this.rear = 0;
    }

    public void printQueue(){
        if (empty()){
            System.out.println("空队列");
        }else {
            for (Object data : elementsData){
                if (data!=null){
                    System.out.print("\t"+data);
                }
            }
        }
    }

}
