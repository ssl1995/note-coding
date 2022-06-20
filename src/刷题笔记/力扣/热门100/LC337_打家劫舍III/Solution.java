package 刷题笔记.力扣.热门100.LC337_打家劫舍III;

import 刷题笔记.力扣.utils.TreeNode;

/**
 * @author SongShengLin
 * @date 2022/2/24 8:59 AM
 * @description
 */
public class Solution {
    /**
     * 打家劫舍III
     * 补充：连续相连的两个节点被盗，房屋报警
     * 输入: root = [3,2,3,null,3,null,1]
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] nums = dfs(root);
        return Math.max(nums[0], nums[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        // 每个节点都看成可以获得两种状态
        // 0位置：不偷；1位置：偷
        int[] nums = new int[2];

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // 不偷：左孩子偷或不偷最大值 + 右孩子偷或不偷最大值
        nums[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷： 左孩子不偷 + 右孩子不偷 + 偷的该节点的值
        nums[1] = left[0] + right[0] + node.val;

        return nums;
    }
}
