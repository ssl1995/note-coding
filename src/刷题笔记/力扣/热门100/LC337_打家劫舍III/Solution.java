package 刷题笔记.力扣.热门100.LC337_打家劫舍III;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

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
        // dfs返回一个2个数的一维数组
        // res[0]=选择当前节点盗窃获取的最大值
        // res[1]=不选择当前节点盗窃获取的最大值
        int[] rootResult = dfs(root);
        return Math.max(rootResult[0], rootResult[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] leftResult = dfs(node.left);
        int[] rightResult = dfs(node.right);
        // 选择当前节点盗窃：它的子节点不能盗窃
        int selectedNode = node.val + leftResult[1] + rightResult[1];
        // 不选择当前节点盗窃：它的左孩子盗窃最大值+它的右孩子盗窃最大值
        int notSelectedNode = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);

        return new int[]{selectedNode, notSelectedNode};
    }

}
