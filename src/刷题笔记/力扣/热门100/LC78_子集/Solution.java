package 刷题笔记.力扣.热门100.LC78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/28 11:15 PM
 * @description
 */
public class Solution {

    /**
     * 子集
     * 数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }


    private void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
        } else if (index < nums.length) {
            // 选择1：跳过该元素
            helper(nums, index + 1, subset, res);

            // 选择2：加入该元素到子集，然后处理下一个元素
            subset.add(nums[index]);
            helper(nums, index + 1, subset, res);

            // 回溯，从子集中删除本轮加入的元素
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = solution.subsets(nums);
        System.out.println(res);
    }
}
