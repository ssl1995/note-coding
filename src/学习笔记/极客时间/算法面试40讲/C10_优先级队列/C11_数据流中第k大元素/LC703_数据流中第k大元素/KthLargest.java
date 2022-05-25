package 学习笔记.极客时间.算法面试40讲.C10_优先级队列.C11_数据流中第k大元素.LC703_数据流中第k大元素;

import java.util.PriorityQueue;

/**
 * @author SongShengLin
 * @date 2022/2/16 9:13 AM
 * @description
 */
public class KthLargest {
    /**
     * 优先级队列
     */
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            // 调用add操作
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            // 数据流中第k大元素一定是排序后，最后k个元素中最小的
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3));
    }
}
