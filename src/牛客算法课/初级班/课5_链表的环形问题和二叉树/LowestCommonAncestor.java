package 牛客算法课.初级班.课5_链表的环形问题和二叉树;

import 牛客算法课.utils.TreeNode;


public class LowestCommonAncestor {
    // 方法1：后序遍历递归法
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
