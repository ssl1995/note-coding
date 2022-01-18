package 刷题笔记.力扣.热门100.LC1_两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/1/18 8:48 AM
 * @description
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
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
