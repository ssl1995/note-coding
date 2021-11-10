package 读书笔记.剑指Offer.第三版.第13章_回溯法.q83_没有重复元素集合的全排列;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2021/11/10 11:10 下午
 * @description
 */
public class Solution {
    // 条件是没有重复数字的集合，找出它的全排列
    // 排列是有顺序的，组合是不要顺序的
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
                swap(nums, i, j);

                helper(nums, i + 1, res);

                // 选择完了，在回到父节点时，回溯清除之前的修改，开始下一个数字`
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
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
