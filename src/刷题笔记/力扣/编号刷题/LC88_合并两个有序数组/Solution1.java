package 刷题笔记.力扣.编号刷题.LC88_合并两个有序数组;

/**
 * @author SongShengLin
 * @date 2022/3/18 09:09
 * @description
 */
public class Solution1 {

    /**
     * 合并两个有序数组
     * 不需要辅助数组，原地修改，因为nums1足够长
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int index = m + n - 1;
        while (p >= 0 && q >= 0) {
            nums1[index--] = nums1[p] < nums2[q] ? nums2[q--] : nums1[p--];
        }
        while (q >= 0) {
            nums1[index--] = nums2[q--];
        }
    }
}
