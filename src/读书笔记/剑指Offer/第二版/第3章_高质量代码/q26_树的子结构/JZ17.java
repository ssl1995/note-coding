package 读书笔记.剑指Offer.第二版.第3章_高质量代码.q26_树的子结构;

import 读书笔记.剑指Offer.utils.TreeNode;

public class JZ17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2) || isContainB(root1, root2);
    }

    private boolean isContainB(TreeNode root, TreeNode match) {
        if (match == null) {
            return true;
        }
        if (root == null || root.val != match.val) {
            return false;
        }
        return isContainB(root.left, match.left) && isContainB(root.right, match.right);
    }
}
