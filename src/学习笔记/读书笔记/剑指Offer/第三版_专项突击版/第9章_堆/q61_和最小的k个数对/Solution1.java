package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第9章_堆.q61_和最小的k个数对;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/10/17 3:05 下午
 * @description
 */
public class Solution1 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 最小堆：int[]是一个从长度为2的数组，第1个数字表示数对中第1个数在nums1中的下标；第2个数字表示数对中第2个数在nums2中的下标
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> nums1[p[0]] + nums2[p[1]]));
        if (nums2.length > 0) {
            // 优化：数组都是递增的，取前k个即可
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                // 数对中第1个数是nums1中取前k个，第2个数先只存0
                minHeap.offer(new int[]{i, 0});
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] index = minHeap.poll();
            res.add(Arrays.asList(nums1[index[0]], nums2[index[1]]));

            if (index[1] < nums2.length - 1) {
                minHeap.add(new int[]{index[0], index[1] + 1});
            }
        }
        return res;
    }
}
