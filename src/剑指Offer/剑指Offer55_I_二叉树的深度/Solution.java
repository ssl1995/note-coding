package 剑指Offer.剑指Offer55_I_二叉树的深度;



import utils.TreeNode;

import java.util.LinkedList;

public class Solution {

    // 法1:递归法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 二叉树深度:左右子树深度最大值+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 法2:二叉树的层次遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // queue:记录上一层的结点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            // temp记录下一层的结点
            LinkedList<TreeNode> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            // queue指向这一层结点
            queue = temp;
            // 高度+1
            res++;
        }
        return res;
    }
}
