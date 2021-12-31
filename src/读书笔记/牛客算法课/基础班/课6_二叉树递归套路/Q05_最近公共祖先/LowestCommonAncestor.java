package 读书笔记.牛客算法课.基础班.课6_二叉树递归套路.Q05_最近公共祖先;

import 读书笔记.牛客算法课.utils.TreeNode;


public class LowestCommonAncestor {
    // 方法:后序遍历递归法,个人认为是最简单的方法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case:遍历指针来到null，遇到o1或者o2，就返回它本身
        if (root == null || root == p || root == q) {
            return root;
        }
        // 当前root结点获取其左右孩子的递归结果
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右孩子信息不为空，那当前遍历指针root来到的结点就是o1,o2的最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 如果左右孩子信息有一个null，记录不为null的那个信息返回
        return left != null ? left : right;
    }
}
