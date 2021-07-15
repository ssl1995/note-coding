package 剑指Offer.正序版.剑指Offer59_I_滑动窗口最大值;

import java.util.LinkedList;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }
        // 双端队列:[队头,...,队尾],存区间下标
        LinkedList<Integer> dequeue = new LinkedList<>();
        // 滑动窗口个数:nums.length - k + 1
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // 遍历原数组
        for (int i = 0; i < nums.length; i++) {
            // 队头:存最大值
            // 当前加入的元素>=对尾元素,队尾元素出队
            while (!dequeue.isEmpty() && nums[i] >= nums[dequeue.peekLast()]) {
                dequeue.pollLast();
            }
            dequeue.addLast(i);
            // 队头弹出:如果队头坐标到达i-k,队头元素就过期了,弹出队头
            if (dequeue.peekFirst() == i - k) {
                dequeue.pollFirst();
            }
            // 记录窗口最大值:从k-1下标开始,每次遍历都要记录一次最大值进结果数组中
            if (i >= k - 1) {
                res[index++] = nums[dequeue.peekFirst()];
            }
        }
        return res;
    }
}
