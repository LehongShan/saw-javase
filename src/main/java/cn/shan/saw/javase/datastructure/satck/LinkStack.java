package cn.shan.saw.javase.datastructure.satck;

/**
 * 链栈
 * Created by shanlehong on 2017/12/18.
 */
public class LinkStack<T> {
    //定义一个内部类Node,Node实例代表链栈的节点
    private  class Node{
        //保存节点数据
        private T data;
        //指向下一个节点的引用
        private Node next;
        public Node(){

        }

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    //保存该链栈的栈顶元素
    private Node top;
    //保存该链栈中已包含的节点数
    private int size;
    //创建空链栈
    public LinkStack(){
        top = null;
    }
    //以指定数据元素来创建链栈
    public LinkStack(T element){
        top = new Node(element,null);
        size++;
    }
    //入栈
    public void push(T element){
        top = new Node(element,top);
        size++;
    }
    //返回栈顶元素
    public T peek(){
        if (empty()) return null;

        return top.data;
    }
    //出栈
    public T pop(){

        Node del = top;
        top = top.next;
        del.next = null;
        size--;
        return del.data;
    }
    //判断该链栈是否为空
    public boolean empty(){
        return top == null;
    }

    //返回链栈的长度
    public int length(){
        return size;
    }

    public void printStack(){
        if (empty()) {
            System.out.println("空栈");
        }else {
            for (Node current = top;current!=null;current = current.next){
                if (current.next==null){
                    System.out.println(current.data);
                }else {
                    System.out.println(current.data);
                    System.out.println("↓");
                }

            }
        }
    }




}
