package 刷题笔记.力扣.编号刷题.LC88_合并两个有序数组;

/**
 * @author SongShengLin
 * @date 2022/1/8 11:42 PM
 * @description
 */
public class Solution {

    /**
     * 合并两个有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int p = 0, q = 0, i = 0;
        while (p < m && q < n) {
            temp[i++] = nums1[p] < nums2[q] ? nums1[p++] : nums2[q++];
        }
        while (p < m) {
            temp[i++] = nums1[p++];
        }
        while (q < n) {
            temp[i++] = nums2[q++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums1[j] = temp[j];
        }
    }
}
