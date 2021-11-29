package 剑指Offer.第二版.剑指Offer55_I_二叉树的深度;

import 剑指Offer.utils.TreeNode;

public class JZ38 {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

}
