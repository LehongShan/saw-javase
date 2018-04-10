package cn.shan.saw.javase.datastructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 三叉链表表示二叉树
 * Created by shanlehong on 2017/12/21.
 */
public class ThreeLinkBinTree<T> {
    public static class Node {
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return data.toString();
        }
    }

    private Node root;

    public ThreeLinkBinTree() {

    }

    public ThreeLinkBinTree(T data) {
        root = new Node(data, null);
    }

    public Node add(Node parent, T data, boolean left) {
        if (parent == null) {
            throw new RuntimeException("该节点为空，无法添加子节点");
        }
        if (left) {
            parent.left = new Node(data, parent);
            return parent.left;
        } else {
            parent.right = new Node(data, parent);
            return parent.right;
        }
    }

    public Node parent(Node node) {
        if (node == null) {
            throw new RuntimeException("该节点为空，无法得出父节点");
        }
        return node.parent;
    }


    public Node left(Node parent) {
        if (parent == null) {
            throw new RuntimeException("该节点为空，无法得出左子节点");
        }
        return parent.left;
    }

    public Node right(Node parent) {
        if (parent == null) {
            throw new RuntimeException("该节点为空，无法得出右子节点");
        }
        return parent.right;
    }

    public Node root() {
        return root;
    }

    public boolean empty() {
        return root() == null;
    }

    //返回树的深度
    public int deep() {
        if (empty()) return 0;
        return deep(root());
    }

    private int deep(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            int maxLeft = 0;
            int maxRight = 0;
            Node left = node.left;
            Node right = node.right;
            while (left != null) {
                int temp = deep(left);
                left = left.left;
                if (temp > maxLeft) {
                    maxLeft = temp;
                }
            }
            while (right != null) {
                int temp = deep(right);
                right = right.left;
                if (temp > maxRight) {
                    maxRight = temp;
                }
            }

            if (maxLeft > maxRight) {
                return maxLeft + 1;
            } else {
                return maxRight + 1;
            }
        }
    }

    /**
     * 先序遍历 DLR
     *
     * @return
     */
    public List<Node> preIterator() {
        return preIterator(root());
    }

    private List<Node> preIterator(Node node) {
        List<Node> list = new ArrayList<>();
        list.add(node);
        while (node.left != null) {
            list.addAll(preIterator(node.left));
        }
        while (node.right != null) {
            list.addAll(preIterator(node.right));
        }
        return list;
    }

    /**
     * 中序遍历 LDR
     *
     * @return
     */
    public List<Node> middleIterator() {
        return middleIterator(root());
    }

    private List<Node> middleIterator(Node node) {
        List<Node> list = new ArrayList<>();
        while (node.left != null) {
            list.addAll(preIterator(node.left));
        }
        list.add(node);
        while (node.right != null) {
            list.addAll(preIterator(node.right));
        }
        return list;
    }

    /**
     * 后序遍历  LRD
     *
     * @return
     */
    public List<Node> postIterator() {
        return postIterator(root());
    }

    private List<Node> postIterator(Node node) {
        List<Node> list = new ArrayList<>();
        while (node.left != null) {
            list.addAll(preIterator(node.left));
        }
        while (node.right != null) {
            list.addAll(preIterator(node.right));
        }
        list.add(node);

        return list;
    }

    /**
     * 广度优先遍历
     *
     * @return
     */
    public List<Node> breadthFirst() {
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if (root() == null) {
            return null;
        } else {
            queue.offer(root());
            while (queue.peek() != null) {
                Node node = queue.peek();
                queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(node.right);
                }
            }
        }
        return list;
    }
}
