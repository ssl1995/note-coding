package 读书笔记.数据结构By慕课网.排序.heapSort.堆.练习题;

import java.util.PriorityQueue;
import java.util.Queue;

// 剑指Offer40：最小的k个数
// 使用jdk的优先队列
public class ToOffer40_2 {
    // 最小的第K个数，用大根堆
    public int[] getLeastNumbers(int[] arr, int k) {
        // 优先级队列默认是小根堆,添加参数修改成大根堆
        Queue<Integer> maxQueue = new PriorityQueue<>(11, (o1, o2) -> o2 - o1);
        // 原数组前k个数放入大根堆
        for (int i = 0; i < k; i++) {
            maxQueue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            // 大根堆堆顶比大，就移除
            if (!maxQueue.isEmpty() && maxQueue.peek() > arr[i]) {
                maxQueue.remove();
                maxQueue.add(arr[i]);
            }
        }
        // 依次移出大根堆，返回结果集数组中
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxQueue.remove();
        }
        return res;
    }
}
