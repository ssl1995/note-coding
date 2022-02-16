package 学习笔记.算法面试40讲.C15_两数之和.LC1_两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/16 10:22 PM
 * @description
 */
public class Solution {
    /**
     * 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        // 存数组值，对应下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
