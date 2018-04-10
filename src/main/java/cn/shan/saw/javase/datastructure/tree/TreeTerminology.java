package cn.shan.saw.javase.datastructure.tree;

/**
 * 树相关的术语：
 * Created by shanlehong on 2017/12/18.
 */
public class TreeTerminology {
/**
 *
 树相关的术语：
 节点：树最基本组成单元，常包括一个数据元素及若干指针用于指向其他节点。
 节点的度：节点拥有的子树的个数被称为节点的度（degree)。
 叶子节点：度为0的节点被称为终端节点或叶子节点。
 分支节点：度不为0的节点被称为分支节点或非终端节点。
 子节点、父节点、兄弟节点：节点的字数的根被称为该节点的子节点，而该节点被称为子树的父节点，
 具有相同父节点(parent)的子节点之间互称为兄弟节点（sibling）。
 节点的层次（level）：节点的层次从根节点开始算起，根的层次值为1，其余节点的层次值为父节点的层次数+1
 树的深度（depth）：树中节点的最大层次值被称为树的深度或者高度。
 有序树和无序树：如果将树中节点的各个子树看成从左到右是有序的（即不能互换），则称该树为有序树，否则称无序树。
 祖先节点（ancestor）：从根到该节点所经分支上的所有节点。
 后代节点：以某个节点为根节点的子树中任一节点都称为该节点的后代节点。
 森林（forest）：森林是由2棵或者2棵以上的互不相交的树的集合，删去一颗树的根，就得到森林。

 树的基本操作：
 初始化：通常指一个构造器，用于创建一个空的树，或者以指定节点为根节点来创建树。
 为指定节点添加子节点。
 判断树是否为空。
 返回根节点。
 返回指定节点（非根节点）的父节点。
 返回指定节点（非叶子节点）的所有子节点。
 返回指定节点（非叶子节点）的第i个子节点。
 返回该树的深度。
 返回指定节点的位置。

 二叉树的基本概念：
 二叉树指的是每个节点最多只能有两个子树的有序树。通常左边的子树被称为“左子树”（left subtree），右边的
 子树被称作“右子树”（right subtree）。由此可见，二叉树依然是树，它是一种特殊的树。
 二叉树的每个节点最多只有2棵子树（不存在度大于2的节点），二叉树的子树有左，右之分，次序不能颠倒。
 树和二叉树两个重要区别：
 树中节点的最大度数没有限制，而二叉树节点的最大度数为2，也就是说二叉树是节点的最大度数为2的树；
 无序树的节点无左，右之分，而二叉树的节点有左，右之分，也就是说二叉树是有序树。
 满二叉树：一颗深度为(2^k) -1个节点，就把这棵树二叉树称为满二叉树。
 完全二叉树： 一颗有n个节点的二叉树，按满二叉树的编号方式对它进行编号，若树中所有节点和二叉树1~n编号完全一致，则称该树为完全二叉树。

 二叉树的基本操作：
 同上诉的树操作。

 二叉树的性质：
 二叉树第i层的节点数目至多为 2^(i-1)  (i>=1)
 深度为k的二叉树至多有2^k  -1 个节点数。满二叉树的每层节点的数量依次为 1 2 4 8 ....
 因此深度为k满二叉树包含的节点数为公比为2的等比数列的前k项总和。
 在任何一颗二叉树中，如果叶子节点的数量为Y ，度数为2的节点数为D，则 Y = D+1。
 具有n个节点的完全二叉树的深度为 log2 n   +1。
 对于一个有n个节点的完全二叉树的节点按层自左向右编号，则对任一编号为i(n>=i>=1)的节点有下列性质。
    当i==1时，节点i是二叉树的根；若i>1，则节点的父节点是i/2。
    若2*i<=n ,则节点i有左孩子，左孩子的编号是2*i，否则，节点无左孩子，并且是叶子节点。
    若2*i+1<=n，则节点i有右孩子，右孩子的编号是 2*i+1;否则，节点无右孩子。
 对一颗有n节点的完全二叉树的节点按层次自左向右编号，1~n/2范围的节点都是有孩子节点的非叶子节点，其余节点都是叶子节点。
 编号为n/2的节点可能只有左节点，也可能既有左节点，又有右节点。

 二叉树存储结构：
 顺序存储：采用数组来记录二叉树的所有节点。
 二叉链表存储：每个节点保留一个left、right域，分别指向其左，右子节点。
 三叉链表存储：每个节点保留一个left、right、parent域，分别指向其左，右子节点和父节点。

 二叉树遍历：
 若采用顺序结构来保存二叉树，直接遍历二叉树底层数组。
 若采用链式结构来保存二叉树，则分深度优先遍历好广大优先遍历。
    深度优先遍历：
        L左 D根  R右
        先序遍历二叉树：DLR
        中序遍历二叉树：LDR
        后序遍历二叉树：LRD

 哈夫曼树：
 哈夫曼树被称为最优二叉树，是一类带权路径最短的二叉树。哈夫曼树是二叉树的一种应用，在信息检索中很常用。
 哈夫曼树的定义：
 节点之间的路径长度：从一个节点到另一个节点之间的分支数量称为两个节点之间的路径长度。
 树的路径长度：从根节点到树种每一个节点的路径长度之和。
 节点的带权路径长度：从该节点到根节点之间的路径长度与节点上权的乘积。
 树的带权路径长度：树中所有叶子节点的带权路劲长度之和。
 带权路径最小的二叉树称为哈夫曼树或者最优二叉树。
 对于哈夫曼树，有一个很重要的定理：对于具有n个叶子节点的哈夫曼树，一共需要2*n-1个节点，哈夫曼树的非叶子节点均由
 2个叶子节点合并产生，不会出现度数为1的节点，而生成非叶子节点的个数是叶子节点的个数-1，因此哈夫曼树的节点数为2*n-1
 */
}
