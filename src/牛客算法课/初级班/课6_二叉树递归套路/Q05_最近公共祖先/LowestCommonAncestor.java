package 牛客算法课.初级班.课6_二叉树递归套路.Q05_最近公共祖先;

import 牛客算法课.utils.TreeNode;


public class LowestCommonAncestor {
    // 方法:后序遍历递归法,个人认为是最简单的方法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 1.遇到null、p、q直接返回root，说明root就是必为祖先
        if (root == null || root == p || root == q) {
            return root;
        }
        // 2.后续遍历获取左右子树节点
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        // 3.左右子树不为空，说明左右子树必包含p、q,祖先就是root
        if (left != null && right != null) {
            return root;
        }
        // 4.左右子树不全空，说明祖先在不为空的子树上
        return left != null ? left : right;
    }
}
