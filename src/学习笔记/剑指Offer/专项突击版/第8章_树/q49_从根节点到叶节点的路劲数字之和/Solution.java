package 学习笔记.剑指Offer.专项突击版.第8章_树.q49_从根节点到叶节点的路劲数字之和;

/**
 * @author SongShengLin
 * @date 2021/10/11 8:02 上午
 * @description
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        // 在遇到叶子节点之前就结束的路径，返回0
        if (root == null) {
            return 0;
        }

        path = path * 10 + root.val;
        // 遇到叶子节点，就返回当前的path值
        if (root.left == null && root.right == null) {
            return path;
        }
        // 遇到还有孩子节点，就左右孩子递归计算path
        return dfs(root.left, path) + dfs(root.right, path);
    }
}
