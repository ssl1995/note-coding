package tag刷题.C05_树问题.剑指Offer55_I_二叉树的深度;




import tag刷题.utils.TreeNode;

import java.util.LinkedList;

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
