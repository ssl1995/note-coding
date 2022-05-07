package 学习笔记.极客时间.算法面试40讲.C43_动态规划.C49_最长递增子序列.LC300_最长递增子序列;

public class Solution1 {

    /**
     * 最长递增子序列
     * 用二分法
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // nums = {10, 9, 2, 5, 3, 7, 101, 18};
        // help = {2, 3, 7, 18, 0, 0, 0, 0};
        // help[i]记录最长子序列的第i个元素
        int[] help = new int[nums.length];
        // maxLen:记录help中有效最长子序列的右边界
        int maxLen = 0;
        for (int num : nums) {
            // 加速：利用二分，在help[0,maxLen]中找第一个>=num的下标
            int left = 0, right = maxLen;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (help[mid] < num) {
                    left = mid + 1;
                } else if (help[mid] >= num) {
                    // 因为right初始化是开区间，所以这里是mid，不是mid+1
                    right = mid;
                }
            }
            // while结束，left指向help中第一个>=num的下标
            // 更新help
            help[left] = num;
            // 更新右边界=更新help中最长子序列最大长度
            // help=[1,2,3]，num=4
            if (maxLen == right) {
                maxLen++;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] arr1 = {10, 9, 2, 5, 3, 7, 101, 18};
        //   tails = {2, 3, 7, 18, 0, 0, 0, 0};
        System.out.println(solution.lengthOfLIS(arr1));
    }
}