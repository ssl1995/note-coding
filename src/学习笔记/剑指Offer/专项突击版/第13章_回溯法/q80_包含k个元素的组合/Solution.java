package 学习笔记.剑指Offer.专项突击版.第13章_回溯法.q80_包含k个元素的组合;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/10 9:30 上午
 * @description
 */
public class Solution {
    /**
     * 选择1-n中k个数组成的所有组合(子集)
     * 示例：n=3,k=2,得到三个组合，[1,2],[1,3],[2,3]
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();

        LinkedList<Integer> combination = new LinkedList<>();
        // 坐标从1开始
        helper(n, k, 1, combination, res);
        return res;
    }

    private void helper(int n, int k, int index, LinkedList<Integer> combination, List<List<Integer>> res) {
        // 子集合的个数到达k，就添加进结果集
        if (combination.size() == k) {
            res.add(new LinkedList<>(combination));
        } else if (index <= n) {
            // 选择1：不加当前数
            helper(n, k, index + 1, combination, res);

            // 选择2：添加当前数，子集跑完后，清除子集结果，回溯回父节点
            combination.add(index);
            helper(n, k, index + 1, combination, res);
            combination.removeLast();
        }
    }
}
