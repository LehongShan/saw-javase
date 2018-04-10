package cn.shan.saw.javase.datastructure.satck;

import java.util.Arrays;

/**
 * 顺序栈
 * Created by shanlehong on 2017/12/15.
 */
public class SequenceStack<T> {
    private int DEFAULT_SIZE = 10;
    //保存数组的长度
    private int capacity;
    //定义当底层数组容量不够时，程序每次增加的数组长度
    private int capacityIncrement = 0;
    //定义个数组用于保存顺序栈的元素
    private Object[] elementsData;
    //保存顺序栈中当前栈的元素
    private int size = 0;
    //以默认数组长度创建空栈
    public SequenceStack(){
        capacity = DEFAULT_SIZE;
        elementsData = new Object[capacity];
    }
    //以一个初始化元素来创建顺序栈
    public SequenceStack(T element){
        this();
        elementsData[0] = element;
        size++;
    }

    /**
     * 以一个指定长度的数组来创建顺序栈
     * @param element
     * @param initSize
     */
    public SequenceStack(T element,int initSize){
       this.capacity = initSize;
        elementsData = new Object[capacity];
        elementsData[0] = element;
        size++;
    }
    //获取顺序栈长度
    public int length(){
        return size;
    }

    //入栈操作 入栈前先确保栈容量空间足够
    public void push(T element){
        ensureCapacity(size+1);
        elementsData[size++] = element;
    }
    //出栈
    public T pop(){
        if (empty()) return null;

        T element = (T) elementsData[size-1];
        elementsData[--size] = null;
        return element;
    }
    //获取栈顶元素
    public T peek(){
        if (empty()) return null;
       return (T) elementsData[size-1];
    }
    public void clear(){
        Arrays.fill(elementsData,null);
        size=0;
    }

    public boolean empty(){
        return size == 0;
    }
    //确保栈空间足够
    private void ensureCapacity(int minCapacity){
        //若最小所需空间大于栈空间则进行扩容操作
        if (minCapacity>capacity){
            if (capacityIncrement>0){
                while (minCapacity>capacity){
                    capacity = capacity+capacityIncrement;
                }
            }else {
                while (minCapacity>capacity){
                    capacity = capacity*2;
                }
            }
            elementsData = Arrays.copyOf(elementsData,capacity);
        }
    }

    public void printStack(){
        if (size==0){
            System.out.println("空栈");
        }
        System.out.println("------------");
        for (int i = elementsData.length-1;i>=0;i--){
            if (elementsData[i]!=null){
                System.out.println(elementsData[i].toString());
                System.out.println("------------");
            }
        }
    }

}
