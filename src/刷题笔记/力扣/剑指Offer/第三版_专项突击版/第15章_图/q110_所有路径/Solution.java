package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第15章_图.q110_所有路径;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/26 9:42 上午
 * @description
 */
public class Solution {
    // 获取有向无环图从第一个结点，到最后一个结点的所有路径
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(0, graph, path, res);

        return res;
    }

    private void dfs(int index, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        // graph[i]中表示第i个结点
        path.add(index);

        if (index == graph.length - 1) {
            res.add(new LinkedList<>(path));
        } else {
            for (int nextNode : graph[index]) {
                // 有向无环图，不用担心重复访问，直接递归
                dfs(nextNode, graph, path, res);
            }
        }

        // 回到前一个结点前，需要将最后结点从path路径中移出
        path.remove(path.size() - 1);
    }
}
