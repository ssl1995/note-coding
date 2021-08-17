package 牛客算法课.基础班.课8_前缀树和贪心算法.Q02_贪心算法;


import java.util.PriorityQueue;
import java.util.Queue;

public class Q5_MadianQuick {

    private Queue<Integer> maxHeap;// 大根堆存较小的N/2个数
    private Queue<Integer> minHeap;// 小根堆存较大的N/2个数

    public Q5_MadianQuick() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        modifyHeap();
    }

    public double findMedian() {
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
