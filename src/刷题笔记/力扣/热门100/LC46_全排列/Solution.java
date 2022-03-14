package 刷题笔记.力扣.热门100.LC46_全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongShengLin
 * @date 2022/1/24 8:43 AM
 * @description
 */
public class Solution {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列 。
     * 你可以 按任意顺序 返回答案。
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        process(nums, 0, res);
        return res;
    }

    private void process(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            // 由于是if+else形式，这里可以不用return返回
        } else {
            // 从i位置往后面临多个选择
            for (int j = i; j < nums.length; j++) {
                // 交换i，j位置
                swap(nums, i, j);

                process(nums, i + 1, res);

                // 回溯：i,j位置归位
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
