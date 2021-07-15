package 剑指Offer.分类版.C01_数组.剑指Offer39_数组中出现次数超一半的数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 方法1:摩尔投票法
    // 出现次数超过一半的数，一定不会被抵消掉，最后留下的一定是它
    public int majorityElement(int[] nums) {
        int cur = 0, count = 0;
        for (int num : nums) {
            // count = 0 说明需要更新cur为当前数字
            if (count == 0) {
                cur = num;
            }
            // cur遇见相同数字，就count+1;否则count-1
            if (cur == num) {
                count++;
            } else {
                count--;
            }
        }
        return cur;
    }

    // 方法2:排序法
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        // 因为数组中一定有超过半数以上的数,排序后中间元素一定是它
        return nums[nums.length / 2];
    }

    // 方法3:哈希法
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 1;
        // map存(元素,出现的次数),并且记录最多出现次数的个数
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
                maxCount = Math.max(maxCount, map.get(num));
            }
        }
        // 遍历map,返回最大次数的key
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("not element");
    }

}
