package 读书笔记.剑指Offer.第二版.剑指Offer55_I_二叉树的深度;




import 读书笔记.剑指Offer.utils.TreeNode;

public class Solution {

    // 法:递归法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 二叉树深度:左右子树深度最大值+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
