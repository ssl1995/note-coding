package 读书笔记.剑指Offer.第三版.第8章_树.q47_二叉树剪枝;

/**
 * @author SongShengLin
 * @date 2021/10/9 7:42 下午
 * @description
 */
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return  null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }
}
