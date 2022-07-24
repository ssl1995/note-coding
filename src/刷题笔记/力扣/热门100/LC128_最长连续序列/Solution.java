package 刷题笔记.力扣.热门100.LC128_最长连续序列;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/15 3:29 PM
 * @Describe:
 */
public class Solution {
    /**
     * 最长连续序列
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public int longestConsecutive(int[] nums) {
        // father[i]:记录每个整数所在子集的父节点
        Map<Integer, Integer> fathers = new HashMap<>();
        // counts[i]:i结点为根结点的子集整数数量
        Map<Integer, Integer> counts = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        // 初始化
        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            set.add(num);
        }

        // 是否包含相邻元素
        for (int num : nums) {
            if (set.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
            if (set.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
        }

        int res = 0;
        for (int length : counts.values()) {
            res = Math.max(res, length);
        }
        return res;
    }

    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int num1, int nums2) {
        int f1 = findFather(fathers, num1);
        int f2 = findFather(fathers, nums2);
        // 两个父节点不相同，就合并两个子图
        if (f1 != f2) {
            // f1挂着f2名下
            fathers.put(f1, f2);

            // f2名下数量更新
            counts.put(f2, counts.get(f1) + counts.get(f2));
        }
    }

    private int findFather(Map<Integer, Integer> fathers, int num) {
        if (fathers.get(num) != num) {
            fathers.put(num, findFather(fathers, fathers.get(num)));
        }
        return fathers.get(num);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {};

        System.out.println(solution.longestConsecutive(nums));
    }
}
