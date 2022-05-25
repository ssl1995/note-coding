package 刷题笔记.力扣;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/07 11:24 AM
 * @Describe: 练习类
 */
public class Solution {

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
