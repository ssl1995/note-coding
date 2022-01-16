package 学习笔记.剑指Offer.第二版.第6章_面试中的各项能力.q59_I_滑动窗口最大值.练习;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author SongShengLin
 * @date 2022/1/16 8:25 PM
 * @description
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length || k < 0) {
            return new int[]{};
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));

    }
}
