package 读书笔记.牛客算法课.基础班.课6_二叉树递归套路.Q02_判断完全二叉树;

import 读书笔记.牛客算法课.基础班.课5_链表的环形问题和二叉树.Q02_二叉树的遍历.TreeNode;

import java.util.LinkedList;

public class IsCST {

    // 判断是否是完全二叉树
    public static boolean isCST(TreeNode head) {
        if (head == null) {
            return false;
        }
        // 层次遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        boolean isLeafNode = false;
        TreeNode leftChild;
        TreeNode rightChild;
        while (!queue.isEmpty()) {
            head = queue.poll();
            leftChild = head.left;
            rightChild = head.right;
            // 1.当前节点有右孩子无左孩子，返回false
            // 2.如果是叶子节点，其左右两个孩子如果存在，返回false
            if (leftChild == null && rightChild != null || isLeafNode && leftChild != null) {
                return false;
            }
            // 中序遍历，队列入节点
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
