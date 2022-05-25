package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q59_I_滑动窗口最大值;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    /**
     * 滑动窗口最大值
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------             -----
     * [1  3  -1] -3  5  3  6  7      3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }
        // 双端队列队头存区间最大值下标
        Deque<Integer> maxIndexDeque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // 双端队列，队头保证存窗口内最大值下标
            while (!maxIndexDeque.isEmpty() && nums[maxIndexDeque.peekLast()] <= nums[i]) {
                maxIndexDeque.pollLast();
            }
            // 存下标
            maxIndexDeque.addLast(i);
            // 数字下标与队列头差值>=窗口长度，队头移出队列
            if (i - maxIndexDeque.peekFirst() >= k) {
                maxIndexDeque.pollFirst();
            }
            // 数字下标>=窗口长度下标，就要记录队头元素
            if (i >= k - 1) {
                res[index++] = nums[maxIndexDeque.peekFirst()];
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
