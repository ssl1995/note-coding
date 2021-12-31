package 读书笔记.剑指Offer.专项突击版.第2章_数组.q10_和为k的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/9/15 8:59 上午
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // map<前i个数字之和，这个和出现的次数>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// map初始化<前0个数字和为0，出现1次>
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}
