package 刷题笔记.力扣.代码随想录.C03_哈希表.Q6_四数之和II;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/07 1:04 PM
 * @Describe:
 */
public class Solution {

    /**
     * LC454：四数之和II
     * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
     * 输出：2
     * 解释：
     * 两个元组如下：
     * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 由于是四个数组给出，不用考虑重复元素，所以可用map
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        // 统计前两个数组和、次数
        for (int a : nums1) {
            for (int b : nums2) {
                int num = a + b;
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        // 统计后2个数组的-和的值
        for (int c : nums3) {
            for (int d : nums4) {
                int num = c + d;
                if (map.containsKey(-num)) {
                    res += map.get(-num);
                }
            }
        }

        return res;
    }

}
