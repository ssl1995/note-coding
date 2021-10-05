package 读书笔记.剑指Offer.第二版.剑指Offer41_数据流的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> maxHeap;// 大根堆存较小的N/2个数
    private Queue<Integer> minHeap;// 小根堆存较大的N/2个数

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        // 每次添加元素，都要发生调整操作
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

    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        solution.addNum(2);
        solution.addNum(3);
        System.out.println(solution.findMedian());
        solution.addNum(4);
        System.out.println(solution.findMedian());
    }
}
