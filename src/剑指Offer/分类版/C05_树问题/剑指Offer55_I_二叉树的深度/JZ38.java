package 剑指Offer.分类版.C05_树问题.剑指Offer55_I_二叉树的深度;

import 剑指Offer.utils.TreeNode;

public class JZ38 {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

}
