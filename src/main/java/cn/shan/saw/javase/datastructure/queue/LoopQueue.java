package cn.shan.saw.javase.datastructure.queue;

/**
 * 循环队列
 * Created by shanlehong on 2017/12/18.
 */
public class LoopQueue<T> {

    private int DEFAULT_SIZE = 30;
    private int capacity;
    private int rear;
    private int front;
    private Object [] elementsData;

    public LoopQueue(){
        capacity = DEFAULT_SIZE;
        elementsData = new Object[capacity];
    }

    public LoopQueue(T element){
        this();
        elementsData[0] = element;
        rear++;
    }

    public LoopQueue(T element,int size){
        capacity = size;
        elementsData = new Object[capacity];
        elementsData[0] = element;
        rear++;
    }

    public void add(T element){

        if (full()){
            throw  new IndexOutOfBoundsException("队列已满");
        }
        elementsData[rear] = element;

        if (rear ==capacity-1){
            rear=0;
        }else{
            rear++;
        }
    }

    public T element(){
        return (T) elementsData[front];
    }

    public T remove(){
        if (empty()){
            throw  new IndexOutOfBoundsException("队列为空");
        }
        T oldValue = (T) elementsData[front];

        elementsData[front]=null;
        if (front ==capacity-1){
            front=0;
        }else{
            front++;
        }
        return oldValue;

    }

    public boolean empty(){
        return rear==front && elementsData[front]==null;
    }

    public boolean full(){
        return rear==front && elementsData[front]!=null;
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
