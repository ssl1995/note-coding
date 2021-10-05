package 读书笔记.剑指Offer.第二版.剑指Offer27_二叉树的镜像;


import 读书笔记.剑指Offer.utils.TreeNode;

import java.util.LinkedList;

public class Solution {


    // 递归法:前序遍历依次进行交换左右子树
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    // 将递归改成辅助栈法
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 栈顶元素出队
            TreeNode top = stack.pop();
            // 使用栈就要先入栈,再交换
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
            // 出队结点的左右孩子节点交换
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;
        }
        return root;
    }
}

