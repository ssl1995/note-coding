package 读书笔记.剑指Offer.专项突击版.第2章_数组.q7_数组中和为0的3个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length >= 3) {
            // nums元素>=3,就先排序
            Arrays.sort(nums);
            // 固定一个数，剩下的2个数开始twoSum
            int i = 0;
            // 至少要剩2个数
            while (i < nums.length - 2) {
                twoSum(nums, i, res);
                // 让下标i跳过重复的数字
                int temp = nums[i];
                while (i < nums.length && nums[i] == temp) {
                    i++;
                }
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 让下标j跳过重复的数字
                int temp = nums[j];
                while (j < k && nums[j] == temp) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
