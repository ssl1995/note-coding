package 刷题笔记.牛客.NC60_判断二叉搜索树和完全二叉树;


import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public boolean[] judgeIt(TreeNode root) {
        return new boolean[]{isValidBST(root), isCST(root)};
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        double preVal = -Double.MAX_VALUE;// 记录前一个结点的值
        while (!stack.isEmpty() || root != null) {
            if (root != null) {// 中序遍历，先存左子树
                stack.push(root);
                root = root.left;
            } else {// 右子树取出，必须>左子树，否则不是BST
                root = stack.pop();
                if (root.val <= preVal) { // 右子树<=pre，必不是BST
                    return false;
                }
                preVal = root.val;// 否则，更新pre
                root = root.right;
            }
        }
        return true;
    }

    public static boolean isCST(TreeNode head) {
        if (head == null) {
            return false;
        }
        // 宽度优先遍历,使用队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        // 标识后续是否是叶子节点
        boolean isLeafNode = false;
        TreeNode leftChild;
        TreeNode rightChild;
        while (!queue.isEmpty()) {
            head = queue.poll();
            leftChild = head.left;
            rightChild = head.right;
            // 1.当前节点有右孩子无左孩子，返回false
            // 2.确定为叶子节点，其左孩子不能有结点，否则返回false
            if (leftChild == null && rightChild != null || isLeafNode && leftChild != null) {
                return false;
            }
            if (leftChild != null) {
                queue.offer(leftChild);
            }
            if (rightChild != null) {
                queue.offer(rightChild);
            } else {// 只要右孩子为空，说明遇到第一个有左无右的结点,那么接下来的结点必为叶子节点
                isLeafNode = true;
            }
        }
        return true;
    }
}
