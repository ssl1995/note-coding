package tag刷题.C04_栈和队列.剑指Offer59_I_滑动窗口最大值;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }
        // num=[2, 3, 4, 2, 6, 2, 5, 1]
        // res=[4, 4, 6, 6, 6, 5]
        // 双端队列队头存区间最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // qmax弹出规则：qmax[尾]<=num[i]就弹出
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            // 过期出队：qmax队头下标是i-size，表示队头元素已过期，队头出队
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            // 开始记录：遍历指针超过窗口长度就记录返回值
            if (i >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        int k = 3;
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
