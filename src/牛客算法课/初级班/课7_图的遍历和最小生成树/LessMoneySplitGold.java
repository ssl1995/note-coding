package 牛客算法课.初级班.课7_图的遍历和最小生成树;

import java.util.PriorityQueue;

public class LessMoneySplitGold {

    public static int lessMoney(int[] arr) {
        // 默认小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.add(num);
        }
        int res = 0;
        // 遍历直到队列长度为1
        while (queue.size() != 1) {
            int sum = queue.poll() + queue.poll();
            res += sum;
            queue.add(res);
        }
        return res;
    }
}
