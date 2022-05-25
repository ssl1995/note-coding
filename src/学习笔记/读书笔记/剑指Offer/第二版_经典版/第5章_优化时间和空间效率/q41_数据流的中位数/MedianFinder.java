package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第5章_优化时间和空间效率.q41_数据流的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /**
     * 大根堆存较小的N/2个数
     */
    private Queue<Integer> maxHeap;
    /**
     * 小根堆存较大的N/2个数
     */
    private Queue<Integer> minHeap;

    /**
     * 得到一个数据流中的中位数
     * [2,3,4]中位数是3
     * [2,3]中位数是2.5,返回double类型
     */
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
