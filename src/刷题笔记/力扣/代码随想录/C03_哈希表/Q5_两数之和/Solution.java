package 刷题笔记.力扣.代码随想录.C03_哈希表.Q5_两数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/07 1:00 PM
 * @Describe:
 */
public class Solution {
    /**
     * LC1：两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        if (Objects.isNull(nums)) {
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
}
