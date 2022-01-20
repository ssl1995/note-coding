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

        int m = nums1.length;
        int n = nums2.length;

        // 总分割线位置
        int totalLeft = m + (n - m + 1) / 2;

        int left = 0;
        int right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            // nums1:[left,i-1,i,right]
            // 短数组分割线左边多1个元数，且短数组分割线左边>长数组分割线位置
            // 大的一边要变小，右指针前移
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                // 否则，大的一边为长数组，左指针到i处
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;

        // 涉及有i-1,j-1，特殊处理左右边界：左边界为负无穷，右边界为正无穷
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];

        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];


        if (((m + n) & 1) == 0) {
            // 偶数，中间两个元素和/2
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
        // 奇数，中间元素
        return Math.max(nums1LeftMax, nums2LeftMax);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }


}
