package 刷题笔记.力扣.编号刷题.LC112_路径之和;

import 刷题笔记.力扣.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/1/10 11:25 PM
 * @description
 */
public class Solution {


    /**
     * 判断二叉树中是否有指定路径和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 越过叶子节点还没有找到，失败
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 到达叶子节点 且 sum-root.val==0，成功
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        // 递归左右子树
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }


}
