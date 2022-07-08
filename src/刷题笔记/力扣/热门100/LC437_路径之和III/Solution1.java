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


    private int t;

    private Map<Integer, Integer> map;

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
        t = targetSum;
        map = new HashMap<>();
        // 初始化：路径和0，出现的次数为1
        map.put(0, 1);

        dfs(root, root.val);

        return res;

    }

    private void dfs(TreeNode node, int sum) {
        if (map.containsKey(sum - t)) {
            res += map.get(sum - t);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        if (node.left != null) {
            dfs(node.left, sum + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, sum + node.right.val);
        }
        // 回溯，消除该节点路径和的影响
        map.put(sum, map.getOrDefault(sum, 0) - 1);

    }


}
