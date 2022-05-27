package 刷题笔记.力扣.剑指Offer.第二版_经典版.第5章_优化时间和空间效率.q39_数组中出现次数超一半的数;


public class Solution {

    /**
     * 出现次数超过一半的数，一定不会被抵消掉，最后留下的一定是它
     * 摩尔投票法
     */
    public int majorityElement(int[] nums) {
        // 摩尔投票法，众数一定不会被抵消掉
        int x = 0, votes = 0;
        for (int num : nums) {
            // 投票数为0时，假设当前数为众数，x==它
            if (votes == 0) {
                x = num;
            }
            // 当前数=众数，票数+1，否则-1
            votes += x == num ? 1 : -1;
        }
        // nums不一定有众数，需要判断一下x是否次数超过数组一半
        int count = 0;
        for (int num : nums) {
            if (x == num) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(arr));
    }
}
