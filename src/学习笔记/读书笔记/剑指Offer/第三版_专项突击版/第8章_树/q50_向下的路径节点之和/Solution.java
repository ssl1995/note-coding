package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第8章_树.q50_向下的路径节点之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/10/11 8:14 上午
 * @description 从根节点到叶节点的所有路径之和；路径：不一定是从根节点开始、叶子节点结束
 */
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        // map<当期节点累加和，该累加和出现的次数>
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化map，根节点累加和=0，出现次数为1
        map.put(0, 1);

        return dfs(root, targetSum, map, 0);
    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> map, int path) {
        if (root == null) {
            return 0;
        }
        path += root.val;

        int count = map.getOrDefault(path - sum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        count += dfs(root.left, sum, map, path);
        count += dfs(root.right, sum, map, path);

        // 函数结束，回到当前节点父节点
        // 回溯：所有递归结束，删除当前节点path和其出现次数
        map.put(path, map.get(path) - 1);

        return count;
    }
}
