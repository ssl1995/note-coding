package 牛客算法课.基础班.课8_前缀树和贪心算法.Q02_贪心算法;

import java.util.PriorityQueue;

public class LessMoneySplitGold {

    // Q:金条怎么分,代价最低?=哈夫曼编码问题
    public static int lessMoney(int[] arr) {
        // 优先级队列:默认小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 将所有数字加入小根堆
        for (int num : arr) {
            queue.add(num);
        }
        int res = 0;
        // 哈夫曼编码:队列只剩最后一个数
        while (queue.size() != 1) {
            // 每次从队列中取两个数字,计算代价再入队列
            int sum = queue.poll() + queue.poll();
            queue.add(sum);
            res += sum;
        }
        return res;
    }
}
