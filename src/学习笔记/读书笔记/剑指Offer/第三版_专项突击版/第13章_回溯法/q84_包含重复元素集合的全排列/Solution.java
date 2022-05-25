package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第13章_回溯法.q84_包含重复元素集合的全排列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2021/11/10 11:31 下午
 * @description
 */
public class Solution {
    /**
     * 给定一个有重复数字的正整数集合，找出它所有的全排列
     * 示例：nums=[1,1,2],结果为[1,1,2],[1,2,1],[2,1,1]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> temp = new LinkedList<>();
            for (int num : nums) {
                temp.add(num);
            }

            res.add(temp);
        } else {
            // 去重，因为交换集合中重复数字得到的全排列是相同的全排列
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                // 当一个值没有被交换到第i位才发生交换
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);

                    swap(nums, i, j);
                    helper(nums, i + 1, res);
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
