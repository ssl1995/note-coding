package 刷题笔记.力扣.剑指Offer.第三版_专项突击版.第13章_回溯法.q82_包含重复元素集合的组合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/10 10:45 下午
 * @description
 */
public class Solution {

    /**
     * 给定一个有重复数字的正整数集合，找出所有元素之和等于t的没有重复元素组合
     * 示例：can=[2,2,2,4,3,3],t=8,结果为[2,2,4],[2,3,3]
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 为了方便跳过后面所有值相同的数字，先将can排序
        Arrays.sort(candidates);

        LinkedList<Integer> com = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        helper(candidates, target, 0, com, res);
        return res;
    }

    private void helper(int[] nums, int target, int index, LinkedList<Integer> com, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(com));
        } else if (target > 0 && index < nums.length) {
            // 选择1：没有选择当前数字，并跳过所有重复数字
            helper(nums, target, getNext(nums, index), com, res);

            // 选择2：选择当前数字
            com.addLast(nums[index]);
            // 输出不能有重复组合，index要+1
            helper(nums, target - nums[index], index + 1, com, res);
            com.removeLast();
        }
    }

    private int getNext(int[] nums, int index) {
        int i = index;
        while (i < nums.length && nums[i] == nums[index]) {
            i++;
        }
        return i;
    }

}
