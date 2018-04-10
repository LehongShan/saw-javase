package cn.shan.saw.javase.datastructure.tree;

/**
 * 顺序存储的二叉树
 * Created by shanlehong on 2017/12/20.
 */
public class ArrayBinTree<T> {

    private Object [] datas;

    private int DEFAULT_DEEP = 8;
    //保存该树的深度
    private int deep;
    private int arraySize;

    //以默认的深度初始化二叉树
    public ArrayBinTree(){
        this.deep = DEFAULT_DEEP;
        arraySize = (int)Math.pow(2,deep) -1;
        datas = new Object[arraySize];

    }
    //以确定深度初始化二叉树
    public ArrayBinTree(int deep){
        this.deep = deep;
        arraySize = (int)Math.pow(2,deep) -1;
        datas = new Object[arraySize];
    }
    //以确定深度、指定根节点创建二叉树
    public ArrayBinTree(int deep,T data){
        this.deep = deep;
        arraySize = (int)Math.pow(2,deep) -1;
        datas = new Object[arraySize];
        datas[0] = data;
    }

    //因为index从零开始 所以以下添加左右节点的时候得+1
    public void add(T data,int index,boolean left){

        if (  datas[index]==null) {
            throw new IndexOutOfBoundsException("索引："+index+"节点为空，不能添加子节点");
        }
        if (left){
            fullLeft(index);
            datas[2*index+1] = data;

        }else {
            fullRight(index);
            datas[2*index+2] = data;
        }

    }
    public int deep(){
        return this.deep;
    }
    public T root(){
        return (T) datas[0];
    }


    public boolean empty(){
        return datas[0]==null;
    }

    public void fullLeft(int index){
        if (2*index+1>arraySize){
            throw new IndexOutOfBoundsException("该二叉树底层已满，左子节点添加失败。");
        }
    }

    public void fullRight(int index){
        if (2*index+2>arraySize){
            throw new IndexOutOfBoundsException("该二叉树底层已满，右子节点添加失败。");
        }
    }

    public T parent(int index){
        if (index>arraySize){
            throw new RuntimeException("索引超出树的最大索引");
        }
        return (T) datas[(index-1)/2];
    }
    public T left(int index){
        if (index> (arraySize/2)-1) {
            throw  new RuntimeException("该节点为叶子节点，无左节点");
        }
        return (T) datas[2*index+1];
    }

    public T right(int index){
        if (index> (arraySize/2)-1) {
            throw  new RuntimeException("该节点为叶子节点，无右节点");
        }
        return (T) datas[2*index+2];
    }

    public int pos(T data){
        for (int i =0; i<arraySize;i++){
            //广度遍历二叉树
            if (datas[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        return java.util.Arrays.toString(datas);
    }
}
