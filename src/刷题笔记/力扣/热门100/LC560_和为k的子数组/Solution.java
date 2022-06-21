package 刷题笔记.力扣.热门100.LC560_和为k的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/27 11:00 AM
 * @description
 */
public class Solution {
    /**
     * 和为k的子数组
     * 返回该数组中和为 k 的连续子数组的个数
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     */
    public int subarraySum(int[] nums, int k) {
        // <(当前元素和构成的)前缀和，该前缀和出现的次数>
        Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
        // 难点:为什么前缀和为0的个数初始化为1，而不是0?
        // 因为当前元素的前缀和=k时，表示匹配成功，个数为1
        map.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            // 当前前缀和是否有sum-k的前缀和
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 更新前缀和
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(solution.subarraySum(nums, k));
    }
}
