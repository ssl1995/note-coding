package 刷题笔记.力扣.热门100.LC1_两数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author SongShengLin
 * @date 2022/5/31 22:59
 * @description
 */
public class Practice {

    /**
     * @param nums
     * @param target
     * @return
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
