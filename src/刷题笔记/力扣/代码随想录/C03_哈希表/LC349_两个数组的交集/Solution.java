package 刷题笔记.力扣.代码随想录.C03_哈希表.LC349_两个数组的交集;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SongShengLin
 * @date 2022/3/20 19:24
 * @description
 */
public class Solution {
    /**
     * LC349_两个数组的交集
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                res.add(num);
            }
        }

        return res.stream().mapToInt(map -> map).toArray();
    }
}
