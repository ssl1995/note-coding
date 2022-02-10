package 学习笔记.剑指Offer.专项突击版.第13章_回溯法.q83_没有重复元素集合的全排列;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/10 11:10 下午
 * @description
 */
public class Solution {
    /**
     * 给定一个没有重复数字的正整数集合，找出它所有的全排列
     * 示例：nums=[1,2,3],结果为[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
     */
    public List<List<Integer>> permute(int[] nums) {
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
            // 排列是剩下的数字中选择一个放进去
            for (int j = i; j < nums.length; j++) {
                // 交换数字就能得到不同的排列
                swap(nums, i, j);

                helper(nums, i + 1, res);

                // 选择完了，在回到父节点时，回溯清除之前的修改，开始下一个数字
                swap(nums, i, j);
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}
