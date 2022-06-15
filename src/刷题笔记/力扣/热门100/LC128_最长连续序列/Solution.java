package 刷题笔记.力扣.热门100.LC128_最长连续序列;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: SongShengLin
 * @Date: 2022/06/15 3:29 PM
 * @Describe:
 */
public class Solution {
    /**
     * 最长连续序列
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 如下的方法会超时
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        while (!set.isEmpty()) {
            Integer num = set.iterator().next();

            int len = dfs(set, num);

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    private int dfs(Set<Integer> set, int num) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(num);
        set.remove(num);

        int len = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            int[] temp = new int[]{poll - 1, poll + 1};

            for (int i = 0; i < 2; i++) {

                if (set.contains(temp[i])) {
                    queue.offer(temp[i]);
                    set.remove(temp[i]);

                    len++;
                }
            }
        }
        return len;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums ={};

        System.out.println(solution.longestConsecutive(nums));
    }
}
