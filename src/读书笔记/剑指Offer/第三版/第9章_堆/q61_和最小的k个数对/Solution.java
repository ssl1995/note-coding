package 读书笔记.剑指Offer.第三版.第9章_堆.q61_和最小的k个数对;

import java.util.*;

/**
 * @author SongShengLin
 * @date 2021/10/17 3:05 下午
 * @description
 */
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 最大堆：存k个和最小的数对
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((arr1, arr2) -> arr2[0] + arr2[1] - (arr1[0] + arr1[1]));
        // 优化：由于nums1和nums2都是递增排序的，较小的数对和只会存在前k个
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    int[] temp = maxHeap.peek();
                    // 如果堆顶数对和>待插入的数对和，堆顶移除
                    if (temp[0] + temp[1] > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] temp = maxHeap.poll();
            res.add(Arrays.asList(temp[0], temp[1]));
        }
        return res;
    }
}
