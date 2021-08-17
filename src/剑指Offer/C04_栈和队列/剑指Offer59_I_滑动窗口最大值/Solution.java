package 剑指Offer.C04_栈和队列.剑指Offer59_I_滑动窗口最大值;

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
            // qmax末尾元素弹出：新加的数比末尾对应的数还大
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            // qmax队头过期，出队头
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            // >=窗口长度，就开始记录返回值
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
