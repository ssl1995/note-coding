package 慕课网数据结构.数组.分金条的最小花费;

import java.util.PriorityQueue;

public class GetMinCost {
    public int getMinCost(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.add(num);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int sum = queue.poll() + queue.poll();
            res += sum;
            // 堆中取出的两个数之和，要再次放回堆中重新排序
            queue.add(sum);
        }
        return res;
    }
}
