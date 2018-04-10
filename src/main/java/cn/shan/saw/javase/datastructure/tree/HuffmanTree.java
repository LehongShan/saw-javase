package cn.shan.saw.javase.datastructure.tree;


import cn.shan.saw.javase.datastructure.queue.LoopQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 哈夫曼树
 * Created by shanlehong on 2017/12/21.
 */
public class HuffmanTree {

    public static class TreeNode<T>{
        T data;
        double weight;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }
        public TreeNode(T data){
            this.data = data;
        }
        public  TreeNode(T data,double weight){
            this.data = data;
            this.weight = weight;
        }

        public TreeNode(T data,double weight,TreeNode left,TreeNode right){
            this.data = data;
            this.weight =weight;
            this.left = left;
            this.right = right;
        }

        public String toString(){
            return "Node:[data:"+data+"weight:"+weight+"]";
        }


    }


    /**
     * 交换list元素
     * @param treeNodeList
     * @param i
     * @param j
     */
    private void swap(List<TreeNode> treeNodeList,int i,int j){
        TreeNode temp = treeNodeList.get(i);
        treeNodeList.set(i,treeNodeList.get(j));
        treeNodeList.set(j,temp);
    }

    public TreeNode createHuffmanTree(List<TreeNode> treeNodeList){


        while (treeNodeList.size()>1){
            //快速排序（权重由大到小排序）
            //得出最小的两个
            sort(treeNodeList);
            int size = treeNodeList.size();
            TreeNode treeNode1 =treeNodeList.get(size-1);
            TreeNode treeNode2 =treeNodeList.get(size-2);
            TreeNode parent = new TreeNode(null,treeNode1.weight+treeNode2.weight,treeNode1,treeNode2);
            treeNodeList.remove(size-1);
            treeNodeList.remove(size-2);
            treeNodeList.add(parent);

        }
        return treeNodeList.get(0);

    }

    /**
     * 快速排序
     * @param nodes
     */
    private void sort(List<TreeNode> nodes){
        quickSort(nodes,0,nodes.size()-1);

    }

    private void quickSort(List<TreeNode> nodes,int low ,int high){
        int start = low;
        int end = high;
        TreeNode keyNode = nodes.get(low);
        while(start<end){
            while(start<end && nodes.get(start).weight>keyNode.weight){
                start++;
            }
            if (nodes.get(start).weight<=keyNode.weight){
                swap(nodes,start,low);
            }
            while(start<end && nodes.get(end).weight< keyNode.weight){
                end--;
            }
            if (nodes.get(end).weight>=keyNode.weight){
                swap(nodes,end,low);
            }
            if (start>low) quickSort(nodes,low,start-1);

            if (end<high) quickSort(nodes,end+1,high);

        }
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<TreeNode> breadthFirst(TreeNode root){
        List<TreeNode> nodes = new ArrayList<>();
        LoopQueue<TreeNode> queue = new LoopQueue<>();
        nodes.add(root);
        queue.add(root);
        while (queue.element()!=null){
            TreeNode node = queue.element();
            TreeNode left = node.left;
            queue.remove();
            if (left!=null){
                queue.add(left);
                nodes.add(node.left);

            }
            TreeNode right = node.right;
            if(right!=null){
                queue.add(right);
                nodes.add(node.right);
            }
        }
        return nodes;
    }


}
