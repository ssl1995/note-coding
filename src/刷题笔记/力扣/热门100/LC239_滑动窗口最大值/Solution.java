package 刷题笔记.力扣.热门100.LC239_滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author SongShengLin
 * @date 2022/6/19 12:06
 * @description
 */
public class Solution {

    /**
     * 滑动窗口最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }
        // 双端队列队：从大到小存数组中的下标
        Deque<Integer> queue = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // 末尾元素<=待加入元素，队尾出队
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 直到队尾>nums[i],队尾存入下标i
            queue.offerLast(i);

            // 队首元素不在i-k范围内，队首出队
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            // i超过k-1坐标，就要保存最大值
            if (i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
