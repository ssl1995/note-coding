package 刷题笔记.力扣.热门100.LC287_寻找重复数;

/**
 * @author SongShengLin
 * @date 2022/2/23 7:48 AM
 * @description
 */
public class Solution {

    /**
     * 寻找重复数
     * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设nums只有一个重复的整数 ，返回这个重复的数 。
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        // 数组元素范围[1,n],
        // 假设有一个数组cnt[n+1],cnt[i]表示nums数组中<=i的个数
        int left = 1, right = n, res = -1;
        while (left <= right) {
            int i = left + (right - left) / 2;
            // count记录nums中<=i的个数
            int count = 0;
            for (int num : nums) {
                if (num <= i) {
                    count++;
                }
            }
            // 如果nums在i前面都没有重复的数,cnt[i]必然<=i,移动左边界查找后面的数
            if (count <= i) {
                left = i + 1;
            } else {
                // 相反，必然有重复的数,移动右边界查找前面的数
                right = i - 1;
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2, 2, 2};
        System.out.println(solution.findDuplicate(nums));
    }
}
