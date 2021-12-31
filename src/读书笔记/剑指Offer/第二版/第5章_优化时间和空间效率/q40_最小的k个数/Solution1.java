package 读书笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q40_最小的k个数;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author SongShengLin
 * @date 2021/12/22 10:49 PM
 * @description
 */
public class Solution1 {
    /**
     * 最小的k个数
     * 最小堆：使用库函数
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 0 || k > arr.length) {
            return new int[]{};
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(solution1.getLeastNumbers(arr, 4)));
    }
}
