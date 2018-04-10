package cn.shan.saw.javase.datastructure.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 树操作测试客户端
 * Created by shanlehong on 2017/12/19.
 */
public class TreeClient {


    @Test
    public void  testTreeParent(){
        TreeParent<String> treeParent = new TreeParent<>("root");
        TreeParent.Node root = treeParent.root();
        System.out.println(root);
        treeParent.addNode("a",root);
        treeParent.addNode("b",root);
        System.out.println("此树的深度为："+treeParent.deep());
        List<TreeParent.Node<String>> nodeList = treeParent.children(root);
        for (TreeParent.Node<String> node:nodeList){
            System.out.println(node);
        }
        System.out.println(treeParent.parent(root));
    }

    @Test
    public void  testTreeChild(){
        TreeChild<String> treeChild = new TreeChild<>("root");
        TreeChild.Node root = treeChild.root();
        System.out.println(root);
        treeChild.addNode("a",root);
        List<TreeChild.Node<String>> nodeList = treeChild.children(root);
        treeChild.addNode("b",nodeList.get(0));
        List<TreeChild.Node<String>> nodeList1 = treeChild.children(root);
        System.out.println("此树的深度为："+treeChild.deep());
        for (TreeChild.Node<String> node:nodeList1){
            System.out.println(node);
        }
    }

    @Test
    public void testArrayBinTree(){
        ArrayBinTree<String> arrayBinTree = new ArrayBinTree<>(4,"root");
        System.out.println("该二叉树的根节点:"+arrayBinTree.root());
        arrayBinTree.add("1R",0,false);
        arrayBinTree.add("1L",0,true);
        System.out.println("该二叉树的根节点的左节点："+arrayBinTree.left(0)+" 右节点："+arrayBinTree.right(0));
        arrayBinTree.add("2L",1,true);
        System.out.println(arrayBinTree);
    }

    @Test
    public void testTwoLinkBinTree(){
        TwoLinkBinTree<String> twoLinkBinTree = new TwoLinkBinTree<>("root");
        System.out.println("该二叉树的根节点:"+twoLinkBinTree.root().data);
        TwoLinkBinTree.Node rootLeft = twoLinkBinTree.add(twoLinkBinTree.root(),"1L",true);
        TwoLinkBinTree.Node rootRight =twoLinkBinTree.add(twoLinkBinTree.root(),"1R",false);

        TwoLinkBinTree.Node nodeLeft2L = twoLinkBinTree.add(rootLeft,"1L2L",true);
        TwoLinkBinTree.Node nodeLeft2R =twoLinkBinTree.add(rootLeft,"1L2R",false);

        TwoLinkBinTree.Node nodeRight2L = twoLinkBinTree.add(rootRight,"1R2L",true);
        TwoLinkBinTree.Node nodeRight2R =twoLinkBinTree.add(rootRight,"1R2R",false);

        System.out.println("rootLeft的左节点："+twoLinkBinTree.left(rootLeft));
        System.out.println("rootLeft的右节点："+twoLinkBinTree.right(rootLeft));

        System.out.println("twoLinkBinTree的深度："+ twoLinkBinTree.deep());
    }

    @Test
    public void testThreeLinkBinTree(){
        ThreeLinkBinTree<String> threeLinkBinTree = new ThreeLinkBinTree<>("root");
        System.out.println("该二叉树的根节点:"+threeLinkBinTree.root().data);
        ThreeLinkBinTree.Node rootLeft = threeLinkBinTree.add(threeLinkBinTree.root(),"1L",true);
        ThreeLinkBinTree.Node rootRight =threeLinkBinTree.add(threeLinkBinTree.root(),"1R",false);

        ThreeLinkBinTree.Node nodeLeft2L = threeLinkBinTree.add(rootLeft,"1L2L",true);
        ThreeLinkBinTree.Node nodeLeft2R =threeLinkBinTree.add(rootLeft,"1L2R",false);

        ThreeLinkBinTree.Node nodeRight2L = threeLinkBinTree.add(rootRight,"1R2L",true);
        ThreeLinkBinTree.Node nodeRight2R =threeLinkBinTree.add(rootRight,"1R2R",false);

        System.out.println("rootLeft的左节点："+threeLinkBinTree.left(rootLeft));
        System.out.println("rootLeft的右节点："+threeLinkBinTree.right(rootLeft));
        System.out.println("nodeLeft2L的右节点："+threeLinkBinTree.parent(nodeRight2L));
        System.out.println("threeLinkBinTree的深度："+ threeLinkBinTree.deep());
    }

    @Test
    public void testHuffmanTree(){
        HuffmanTree.TreeNode treeNodeA = new HuffmanTree.TreeNode("A",5.00);
        HuffmanTree.TreeNode treeNodeB = new HuffmanTree.TreeNode("B",10.00);
        HuffmanTree.TreeNode treeNodeC = new HuffmanTree.TreeNode("C",16.00);
        HuffmanTree.TreeNode treeNodeD = new HuffmanTree.TreeNode("D",8.00);
        List< HuffmanTree.TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(treeNodeA);
        treeNodes.add(treeNodeB);
        treeNodes.add(treeNodeC);
        treeNodes.add(treeNodeD);
        HuffmanTree huffmanTree = new HuffmanTree();
        HuffmanTree.TreeNode rootNode = huffmanTree.createHuffmanTree(treeNodes);
        List<HuffmanTree.TreeNode> huffmanTreeBreadthFirst =   huffmanTree.breadthFirst(rootNode);
        System.out.println(huffmanTreeBreadthFirst);

    }
}
