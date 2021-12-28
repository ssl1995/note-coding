package 剑指Offer.第二版.第6章_面试中的各项能力.q59_I_滑动窗口最大值;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }
        // 双端队列队头存区间最大值下标
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 双端队列，队头保证存窗口内最大值下标
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 存下标
            queue.addLast(i);
            // 队头元素值达到i-k，出队列
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            // >=窗口长度，就开始记录返回值
            if (i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
