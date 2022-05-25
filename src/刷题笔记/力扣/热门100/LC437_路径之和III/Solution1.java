package 刷题笔记.力扣.热门100.LC437_路径之和III;

import 学习笔记.读书笔记.剑指Offer.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/25 9:11 AM
 * @description
 */
public class Solution1 {

    private Map<Integer, Integer> map;
    private int target;
    private int res;

    /**
     * 路径之和III
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // map<路径和，到达当前路径和的个数>
        map = new HashMap<>();
        // 初始化map，路径和为0，代表达到目标结果
        map.put(0, 1);

        this.target = targetSum;
        res = 0;
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (map.containsKey(sum - target)) {
            res += map.get(sum - target);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        if (node.left != null) {
            dfs(node.left, sum + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, sum + node.right.val);
        }

        map.put(sum, map.getOrDefault(sum, 0) - 1);

    }


}
