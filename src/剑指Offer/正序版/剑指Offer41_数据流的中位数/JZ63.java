package 剑指Offer.正序版.剑指Offer41_数据流的中位数;

import java.util.PriorityQueue;

public class JZ63 {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);// 大根堆存较小的N/2个数
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();// 小根堆存较大的N/2个数

    public void Insert(Integer num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        modifyHeap();
    }

    public double GetMedian() {
        if (maxHeap.isEmpty()) {
            return -1.0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.00000;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }

    private void modifyHeap() {
        // 差距达到2才会发生调整
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }
}
