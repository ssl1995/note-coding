package 力扣.剑指Offer.第三版.c2_数组.q11_0和1个数相同的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2021/9/15 9:23 上午
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        // Map<当前下标累加和，当前下标>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// 初始化map:<累加和0，下标-1>
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            // 遇到原数组中的0，累加-1；遇到1，累加1
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {// 遇到map中已经有累加和为0，就统计长度
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {// 没有遇到累加和为0，就统计map<累加和，当前下标>
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        Solution solution = new Solution();
        int res = solution.findMaxLength(nums);
        System.out.println(res);
    }
}
