package 剑指Offer.正序版.剑指Offer41_数据流的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder1 {
    // A:存较小的N个数,使用大根堆
    private Queue<Integer> A;
    // B:存较大的N个数,使用小根堆
    private Queue<Integer> B;

    public MedianFinder1() {
        A = new PriorityQueue<>((a, b) -> (b - a));
        B = new PriorityQueue<>();
    }

    // 将待排序数据流划分为:maxPq,minPq
    public void addNum(int num) {
        // 两个桶元素个数相同,规定先入前面的A桶,A桶大根堆排序后,再入B桶
        if (A.size() == B.size()) {
            A.add(num);
            B.add(A.poll());
        } else { // 两个桶元素个数不同,规定先入B桶,B桶小根堆排序后,再入A桶
            B.add(num);
            A.add(B.poll());
        }
        // 以上方式:数据总量为奇数时,B桶比A桶多一个元素;总量为偶数时,两个桶长度相同
    }

    public double findMedian() {
        // A,B桶相同时,由于最终是往B桶加入数据,所以返回B的堆顶元素
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : B.peek();
    }
}
