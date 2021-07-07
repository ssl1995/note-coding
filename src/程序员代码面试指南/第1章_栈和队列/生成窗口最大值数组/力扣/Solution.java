package 程序员代码面试指南.第1章_栈和队列.生成窗口最大值数组.力扣;

import java.util.LinkedList;

class Solution {
    // 剑指 Offer 59 - I. 滑动窗口的最大值
    // 239. 滑动窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || nums.length < 1 || k < 1) {
            return new int[]{};
        }
        LinkedList<Integer> q = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            if (q.peekFirst() == i - k) {
                q.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}