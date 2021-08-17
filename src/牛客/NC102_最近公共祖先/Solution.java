package 牛客.NC102_最近公共祖先;

import 剑指Offer.utils.TreeNode;

public class Solution {

    // Q:二叉树的最近公共祖先
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return process(root, o1, o2).val;

    }

    public TreeNode process(TreeNode root, int o1, int o2) {
        // base case:遍历指针来到null，遇到o1或者o2，就返回它本身
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        // 当前root结点获取其左右孩子的递归结果
        TreeNode left = process(root.left, o1, o2);
        TreeNode right = process(root.right, o1, o2);
        // 如果左右孩子信息不为空，那当前遍历指针root来到的结点就是o1,o2的最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 如果左右孩子信息有一个null，记录不为null的那个信息返回
        return left != null ? left : right;
    }
}
