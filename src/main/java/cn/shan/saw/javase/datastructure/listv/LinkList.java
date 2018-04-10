package cn.shan.saw.javase.datastructure.listv;

/**
 * 链表
 * Created by shanlehong on 2017/12/15.
 */
public class LinkList<T> {

    private class Node {
        //保存节点的数据
        private T data;
        //指向下一节点的应用
        private Node next;
        //无参属性
        public Node(){

        }
        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    //保存链表头结点
    private Node header;
    //保存链表尾节点
    private Node tail;
    //保存链表中已包含的节点数
    private int size;
    //空链表初始化
    public LinkList(){
        header = null;
        tail = null;
    }
    //以指定数据元素来创建链表，该链表只有一个元素
    public LinkList(T element){
        header = new Node(element,null);
        //只有一个元素的时候头尾节点都指向该节点
        tail = header;
        size++;
    }

    //返回链表长度
    public int length(){
        return  size;
    }
    //通过索引获取元素
    public T get(int index){
        return  getNodeByIndex(index).data;
    }

    //根据索引index获取指定位置的节点
    private Node getNodeByIndex(int index){
        if (index<0 || index >size-1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        //header 节点
        Node current = header;
        for (int i = 0;i<size && current!=null;i++,current = current.next){
            if (i==index){
                return current;
            }
        }
        return null;

    }

    public int locate(T element){
        Node current = header;
        for (int i = 0;i<size && current!=null;i++,current = current.next){
            if (element==current.data){
                return i;
            }
        }
        return -1;
    }

    public void insert(T element,int index){
        if (index<0 || index >size-1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        //若是空表
        if (header==null){
            add(element);
        }else {
            if (index==0){
                addAtHeader(element);
            }else {
                Node lastNode = getNodeByIndex(index-1);
                lastNode.next = new Node(element,lastNode.next);
                size++;
            }
        }
    }
    //尾插法为链表添加新节点
    public void add(T element){
        if (header == null){
            header = new Node(element,null);
            tail = header;
        }else {
            //创建新节点
            Node newNode = new Node(element,null);
            //尾节点的下一节点指向新节点
            tail.next = newNode;
            //以新节点作为尾节点
            tail = newNode;
        }
        size ++;
    }

    //头插法为链表新节点
    public void addAtHeader(T element){
        //创建新节点 使新节点的下一节点指向原来的header
        header = new Node(element,header);
        //若插入的是空表则
        if (tail ==null){
            tail = header;
        }
        size++;
    }

    public T delete(int index){
        if (index<0 || index >size-1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node del;
        if (index ==0){
            del = header;
            header = header.next;
        }else {
            Node prev = getNodeByIndex(index-1);
            del = prev.next;
            prev.next = del.next;
            del.next = null;

        }
        size--;
        return  del.data;
    }

    public T remove(){
        return  delete(size-1);
    }

    public boolean empty(){
        return size==0;
    }

    public void clear(){
        header = null;
        tail = null;
        size=0;
    }

    public void printLinkList(){
        if (empty()){
            System.out.println("空链表");
        }else {
            for (Node current = header;current!=null;current = current.next){
                if (current.next==null){
                    System.out.print(current.data);
                }else {
                    System.out.print(current.data+"->");
                }
            }
        }
    }



}
