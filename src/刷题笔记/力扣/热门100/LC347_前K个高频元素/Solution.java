package 刷题笔记.力扣.热门100.LC347_前K个高频元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author SongShengLin
 * @date 2022/7/5 09:01
 * @description
 */
public class Solution {

    /**
     * 前k个高频元素
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     */
    public int[] topKFrequent(int[] nums, int k) {
        // map存数字和其出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 最小值堆存前k大的频率的Entry:按照value从小到大排序，因为要把教小的排出去
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (minHeap.peek().getValue() < entry.getValue()) {
                // 最小值堆堆顶是小的，出堆
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int t = 2;
        System.out.println(Arrays.toString(solution1.topKFrequent(nums, t)));
    }
}
