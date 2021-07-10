package 牛客算法课.初级班.课6_二叉树递归套路.Q06_找后继结点;

import 牛客算法课.初级班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.Node;

public class SuccessorNode {

    // 定义一个有parent指针的node
    // 判断某个结点的后继结点
    public Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        // 情况1:当前节点有右树,它的后继就是右树中最左结点
        if (node.right != null) {
            return getLeftMost(node);
        } else {
            // 情况2:当前节点无右树,后继结点是:当它是它父节点的左孩子,该父就是它后继结点
            // 因为后继结点是中序遍历排在cur后的结点
            Node parent = node.parent;
            // parent != null:保证最右叶子节点无后继,它的父总会遍历到根节点的父=null值
            // parent.left != node:除最右叶子节点外,其余结点通用的情况:当它是它父节点的左孩子,该父就是它后继结点
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            // 返回父即可
            return parent;
        }
    }

    public Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        // node有左树就一直往下遍历
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
