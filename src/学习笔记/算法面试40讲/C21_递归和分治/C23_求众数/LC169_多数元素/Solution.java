package 学习笔记.算法面试40讲.C21_递归和分治.C23_求众数.LC169_多数元素;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongShengLin
 * @date 2022/2/17 11:03 PM
 * @description
 */
public class Solution {
    /**
     * 多数元素
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 条件给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("不存在多数元素");
    }
}
