package tag刷题.C08_位运算.剑指Offer56_II_数组中数字出现的次数II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 法1:遇事不决,找哈希爸爸
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                // 已经包含过的，记为-1,减少get操作
                map.put(num, -1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 法2:有限状态自动机
    public int singleNumber2(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] arr={3,3,3,5};
        Solution solution = new Solution();
        int res = solution.singleNumber2(arr);
        System.out.println(res);
    }

}
