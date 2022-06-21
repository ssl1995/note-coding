package 刷题笔记.力扣.热门100.LC437_路径之和III;

import 刷题笔记.力扣.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/25 9:11 AM
 * @description
 */
public class Solution1 {

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
        // key=前缀和；value=出现target-curSum的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 假设根节点有一个父节点，其前缀和为0，有一条路径为1
        map.put(0, 1);

        return dfs(root, map, targetSum, 0);

    }

    private int dfs(TreeNode node, Map<Integer, Integer> map, int targetSum, int curSum) {
        if (node == null) {
            return 0;
        }
        // 当前结点的前缀和
        curSum += node.val;

        int res = 0;
        // 同一条路径上是否出现过curSum-TargetSum的前缀和
        res += map.getOrDefault(curSum - targetSum, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        res += dfs(node.left, map, targetSum, curSum);
        res += dfs(node.right, map, targetSum, curSum);

        // 回溯，消除本层的影响
        map.put(curSum, map.get(curSum) - 1);

        return res;
    }


}
