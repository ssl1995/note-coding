package 刷题笔记.力扣.剑指Offer.第二版.数据结构.栈与队列.q59_I_滑动窗口最大值;


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

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

}
