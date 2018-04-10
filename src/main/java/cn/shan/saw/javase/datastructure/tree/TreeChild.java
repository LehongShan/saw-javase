package cn.shan.saw.javase.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 子节点表示法
 * Created by shanlehong on 2017/12/19.
 */
public class TreeChild<E> {

    private static  class SonNode{
        //记录当前节点的位置
        private int pos;
        private SonNode next;
        public SonNode(int pos,SonNode next){
            this.pos = pos;
            this.next = next;
        }
    }

    public static class Node<T>{
        T data;
        SonNode first;
        public Node( T data){
            this.data = data;
            this.first = null;
        }

        public String toString(){
            if (first != null){
                return "TreeChild$Node[data="+data+", first="+ first.pos+"]";
            }else {
                return "TreeChild$Node[data="+data+", first=-1]";
            }
        }
    }

    private final int DEFAULT_TREE_SIZE =100;
    private int treeSize;
    private Node<E> [] nodes;
    private int nodeNums;

    public TreeChild(E data){

        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data);
        nodeNums++;
    }

    public TreeChild(E data,int treeSize){

        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<>(data);
        nodeNums++;
    }

    public void addNode(E data,Node parent){
        if (nodeNums == treeSize){
            throw new IndexOutOfBoundsException("该树已满");
        }

        if (nodes[nodeNums] == null){
            if (parent.first==null){
                parent.first = new SonNode(nodeNums,null);
                nodes[nodeNums++] = new Node<>(data);
            }else {
                SonNode firstNode =  parent.first;
                firstNode.next =new SonNode(nodeNums,null);
                nodes[nodeNums++] = new Node<>(data);
            }
        }
    }

    public List<Node<E>> children(Node<E> parent) {
        List<Node<E>> childrenList = new ArrayList<>();
        SonNode next = parent.first;
        while (next !=null){
            childrenList.add(nodes[next.pos]);
            next = next.next;
        }
        return childrenList;
    }

    public Node<E> children(Node<E> parent,int index){
        List<Node<E>> childrenList = new ArrayList<>();
        SonNode next = parent.first;
        while (next !=null){
            childrenList.add(nodes[next.pos]);
            if (next.pos == index){
               return nodes[next.pos];
            }
        }
        return null;
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

    public Node<E> root(){
        return nodes[0];
    }

    //返回树的深度
    public int deep(){
        return  deep(root());
    }
    //这是一个递归方法：每棵子树的深度为其所有子树的最大深度+1
    public int deep(Node<E> parent){
        if (parent.first == null){
            return 1;
        }else {

            SonNode next = parent.first;
            //记录所有子树的最大深度
            int max = 0;
            while (next!=null){
                //获取以其子节点为根的树的深度
               int temp =  deep(nodes[next.pos]);
               if (temp>max){
                   max = temp;
               }
               next = next.next;
            }
            //最后返回所有子树深度加1
            return max+1;
        }
    }


}
