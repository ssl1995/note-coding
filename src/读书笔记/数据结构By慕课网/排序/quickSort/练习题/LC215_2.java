
package 读书笔记.数据结构By慕课网.排序.quickSort.练习题;

import java.util.PriorityQueue;

/**
 * @Author ssl
 * @Date 2020/12/5 13:35
 * @Description 215. 数组中的第K个最大元素
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class LC215_2 {
    // 面试，使用优先级队列方法
    public int findKthLargest(int[] nums, int k) {
        // 找出第K大，就用最小堆，PriorityQueue默认是最小值堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // [0,k)有k个数，加入最小值
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        // [k,n-1],堆顶比当前数还小就出队，添加该元素
        for (int i = k; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() < nums[i]) {
                queue.remove();
                queue.add(nums[i]);
            }
        }
        // 返回堆顶元素
        return queue.peek();
    }
}
