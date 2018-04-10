package cn.shan.saw.javase.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 父节点表示法实现一棵树
 * Created by shanlehong on 2017/12/19.
 */
public class TreeParent<E> {

    public static class Node<T>{
        T data;
        //记录其父节点的位置
        int parent;
        public Node(){

        }
        public Node(T data){
            this.data = data;
        }
        public Node(T data,int parent){
            this.data = data;
            this.parent = parent;
        }

        public String toString(){
            return "TreeParent$Node[data="+data+",parent ="+parent+"]";
        }
    }

    private final int DEFAULT_SIZE = 100;
    private int treeSize = 0;
    //使用一个Node[]数组记录该树里的所有节点
    private Node<E> [] nodes;
    //记录节点数
    private int nodeNums;
    //以根节点创建树
    public TreeParent(E data){
        treeSize = DEFAULT_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data,-1);
        nodeNums++;
    }

    public TreeParent(E data , int treeSize){
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data,-1);
        nodeNums++;
    }

    public boolean empty(){
        return  nodes[0] == null;
    }

    //返回根节点值
    public Node<E> root(){
        if (empty()) return null;
        return nodes[0];
    }

    public void addNode(E data,Node<E> parent){
        if (nodeNums == treeSize){
            throw new IndexOutOfBoundsException("树已满");
        }
        if (nodes[nodeNums]==null){
            nodes[nodeNums++]= new Node<>(data,pos(parent));
        }
    }

    //返回指定节点的父节点
    public Node<E> parent(Node node){
        if (empty()||node.parent==-1) return null;

        return nodes[node.parent];
    }
    //返回指定节点的子节点
    public List<Node<E>> children(Node node){
        List<Node<E>> list = null;
        for (int i=0;i<nodeNums;i++){
            if (nodes[i]!=null && nodes[i].parent==pos(node)){
                synchronized (list){
                    if (list==null){
                        list =  new ArrayList<>();
                    }
                    list.add(nodes[i]);
                }
            }
        }
        return list;
    }

    //返回树的深度
    public int deep(){
        //用于记录的最大深度
        int max = 0;
        for (int i=0;i<nodeNums;i++){
            int def = 1;
            int parent = nodes[i].parent;
            while(parent!=-1 && nodes[parent]!=null){
                //继续向上搜索父节点
                parent = nodes[parent].parent;
                def++;
            }
            if (max<def){
                max = def;
            }
        }
        return max;
    }
    //返回指定节点的位置
    public int pos(Node node){
        for (int i =0; i<nodeNums;i++){
            if (nodes[i]==node){
                return i;
            }
        }
        return -1;
    }

}
