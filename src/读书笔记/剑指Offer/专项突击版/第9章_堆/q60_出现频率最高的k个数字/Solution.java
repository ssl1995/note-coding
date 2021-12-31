package 读书笔记.剑指Offer.专项突击版.第9章_堆.q60_出现频率最高的k个数字;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author SongShengLin
 * @date 2021/10/17 2:49 下午
 * @description
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map存数字和其出现的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 最小值堆存前k大的频率的Entry
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        // 遍历map中的entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (minHeap.peek().getValue() < entry.getValue()) {// 最小值堆存前k大的entry，遇到堆顶<待插入，才poll
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        // 放入结果集
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }
}
