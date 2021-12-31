package 学习笔记.牛客算法课.基础班.课6_二叉树递归套路.Q06_找后继结点;

import 学习笔记.牛客算法课.基础班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.TreeNode;

public class SuccessorNode {

    // 判断二叉树中某个结点的后继结点(node是有父指针的结点)
    public TreeNode getSuccessorNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 情况1:当前节点有右树,它的后继就是右树中最左结点
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            // 情况2:当前节点无右树,后继结点是:当前节点是它父节点的左孩子,该父就是它后继结点
            TreeNode parent = node.parent;
            // parent != null:保证最右叶子节点无后继,它的父总会遍历到根节点的父=null值
            // parent.left != node:除最右叶子节点外,其余结点通用的情况:当它是它父节点的左孩子,该父就是它后继结点
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // 返回当前节点左子树最右节点
    public TreeNode getLeftMost(TreeNode node) {
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
