package cn.shan.saw.javase.datastructure.tree;

/**
 * 二叉链表存储二叉树
 * Created by shanlehong on 2017/12/21.
 */
public class TwoLinkBinTree<T> {
    public static class Node{
        Object data;
        Node left;
        Node right;

        public Node(){

        }
        public Node(Object data){
            this.data = data;
        }

        public Node(Object data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString(){
            return data.toString();
        }

    }


    private Node root;

    public TwoLinkBinTree(){

    }
    public TwoLinkBinTree(T data){
        root = new Node(data);
    }

    public TwoLinkBinTree(Node root){
        this.root = root;
    }


    public Node add( Node node,T data,boolean left){
        if (node==null){
            throw new RuntimeException("该节点为空");
        }

        if (left){
            if (node.left!=null){
                throw new RuntimeException("该节点已经存在左子节点");
            }
            node.left = new Node(data);
            return  node.left;
        }else {
            if (node.right!=null){
                throw new RuntimeException("该节点已经存在右子节点");
            }
            node.right = new Node(data);
            return  node.right;
        }
    }

    public Node left(Node parent){
        if (parent == null){
            throw new RuntimeException("该节点为空节点");
        }
        return parent.left;
    }

    public Node right(Node parent){
        if (parent == null){
            throw new RuntimeException("该节点为空节点");
        }
        return parent.right;
    }

    public boolean empty(){
        return  root == null;
    }
    public Node root(){
        if ( empty())  return null;

        return root;

    }
    //返回树的深度
    public int deep(){
        if (empty()) return 0;
        return deep(root());
    }

    private int deep(Node node){
        if (node==null){
            return 0;
        }
        if (node.left==null && node.right == null){
            return 1;
        }else {
            int maxLeft = 0;
            int maxRight = 0;
            Node left = node.left;
            Node right = node.right;
            while(left!=null){
                int temp = deep(left);
                left = left.left;
                if (temp>maxLeft) {
                    maxLeft = temp;
                }
            }
            while(right!=null){
                int temp = deep(right);
                right = right.left;
                if (temp>maxRight) {
                    maxRight = temp;
                }
            }

            if (maxLeft>maxRight){
                return maxLeft+1;
            }else {
                return maxRight+1;
            }
        }
    }



}
