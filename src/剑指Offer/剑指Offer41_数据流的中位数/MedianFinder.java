package 剑指Offer.剑指Offer41_数据流的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> minQueue;
    private Queue<Integer> maxQueue;

    public MedianFinder() {
        this.minQueue = new PriorityQueue<>();
        this.maxQueue = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // 初始化:规定先加入max队列
        // 加入数据:num<=max.peek(),入max队列;否则入min队列
        if (maxQueue.isEmpty() || num <= maxQueue.peek()) {
            maxQueue.add(num);
        } else {
            minQueue.add(num);
        }
        // 两个队列个数差达到2,调整队列长度
        if (maxQueue.size() == minQueue.size() + 2) {
            minQueue.add(maxQueue.poll());
        }
        if (minQueue.size() == maxQueue.size() + 2) {
            maxQueue.add(minQueue.poll());
        }
    }

    public double findMedian() {
        int maxSize = maxQueue.size();
        int minSize = minQueue.size();
        // 判断长度为0的三种情况
        if (maxSize + minSize == 0) {
            return 0.0;
        }
        if (maxSize == 0) {
            return minQueue.peek();
        }
        if (minSize == 0) {
            return maxQueue.peek();
        }
        // 长度都不为0,才能出队列
        int maxPeek = maxQueue.peek();
        int minPeek = minQueue.peek();
        // 数据流长度为偶数:两个队列长度相同
        if (maxSize == minSize) {
            return (maxPeek + minPeek) / 2.0;
        }
        // 数据流长度为奇数:谁长就出谁的队列
        return maxSize > minSize ? maxPeek : minPeek;
    }
}
