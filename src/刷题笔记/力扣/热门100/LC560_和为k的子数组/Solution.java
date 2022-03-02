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
        // <前缀和，该前缀和出现的次数>
        Map<Integer, Integer> map = new HashMap<>(nums.length + 1);
        // 难点:为什么前缀和为0的个数初始化为1，而不是0?
        // nums = [3,...], k = 3时
        // 扫描完第一个数3后，preSum=3，preSum-k=0，说明匹配成功有1个
        map.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            // 查看当前数的前缀和是否满足pre-k
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            // 更新前缀和
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(solution.subarraySum(nums, k));
    }
}
