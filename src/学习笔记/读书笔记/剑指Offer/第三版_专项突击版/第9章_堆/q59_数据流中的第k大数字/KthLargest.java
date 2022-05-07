package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第9章_堆.q59_数据流中的第k大数字;

import java.util.PriorityQueue;

/**
 * @author SongShengLin
 * @date 2021/10/15 8:51 上午
 * @description
 */
public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
