package 刷题笔记.力扣.热门100.LC4_寻找两个正序数组的中位数;

/**
 * @author SongShengLin
 * @date 2022/1/19 8:39 AM
 * @description
 */
public class Solution {
    /**
     * 寻找两个正序数组中的中位数
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 加快搜索，让nums1变成短数组
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // m是短数组的长度
        int m = nums1.length;
        // n是长数组的长度
        int n = nums2.length;

        int left = 0;
        int right = m;

        int leftMax = 0;
        int rightMin = 0;

        while (left <= right) {
            // i对短数组每次进行二分，j是根据left_part和right_part推出来的公式
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums1_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums1_i = (i == m ? Integer.MAX_VALUE : nums1[i]);

            int nums2_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums2_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums1_im1 <= nums2_j) {
                // 找出左半部分的最大值和右半部分的最小值
                leftMax = Math.max(nums1_im1, nums2_jm1);
                rightMin = Math.min(nums1_i, nums2_j);

                left = i + 1;
            } else {
                // 以i的左右两边来二分，不是right = j-1, 与j没关闭
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (leftMax + rightMin) / 2.0 : leftMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4};
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }


}
