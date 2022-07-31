package 刷题笔记.力扣.热门100.LC4_寻找两个正序数组的中位数.左神解法;

/**
 * @author SongShengLin
 * @date 2022/7/31 21:06
 * @description
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        boolean even = (size & 1) == 0;
        if (nums1.length != 0 && nums2.length != 0) {
            if (even) {
                return (double) ((findKthNum(nums1, nums2, size / 2)) + (findKthNum(nums1, nums2, size / 2 + 1)));
            } else {
                return findKthNum(nums1, nums2, size / 2 + 1);
            }
        } else if (nums1.length != 0) {
            if (even) {
                return (double) (nums1[(size - 1) / 2] + nums1[size / 2]) / 2;
            } else {
                return nums1[size / 2];
            }
        } else if (nums2.length != 0) {
            if (even) {
                return (double) (nums2[(size - 1) / 2] + nums2[size / 2]) / 2;
            } else {
                return nums2[size / 2];
            }
        } else {
            return 0;
        }

    }


    private int findKthNum(int[] arr1, int[] arr2, int k) {
        int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length < arr2.length ? arr1 : arr2;
        int l = longs.length;
        int s = shorts.length;
        // 1<=k<=短数组长度,比如 1<=k<=10,第k小的数在短数组内
        if (k <= s) {
            return getUpMedian(shorts, 0, k - 1, longs, 0, k - 1);
        }
        // 长数组长度 <k<=两个数组之和
        if (k > l) {
            if (shorts[k - l - 1] >= longs[l - 1]) {
                return shorts[k - l - 1];
            }
            if (longs[k - s - 1] >= shorts[s - 1]) {
                return longs[k - s - 1];
            }
            return getUpMedian(shorts, k - l, s - 1, longs, k - s, l - 1);
        }
        // 短数组长度<=k<=长数组长度,比如 10<k<=17
        if (shorts[s - 1] <= longs[k - s - 1]) {
            return longs[k - s - l];
        }
        return getUpMedian(shorts, 0, s - 1, longs, k - s, k - 1);
    }


    /**
     * 两个有序、长度相同的数组中，求合并后的上中位数
     */
    private int getUpMedian(int[] A, int s1, int e1, int[] B, int s2, int e2) {
        int mid1 = 0;
        int mid2 = 0;
        while (s1 < e1) {
            mid1 = s1 + (e1 - s1) / 2;
            mid2 = s2 + (e2 - s2) / 2;
            // 两个有序数组，中间值如果相同，那就是合并后的上中位数
            if (A[mid1] == B[mid2]) {
                return A[mid1];
            }
            // 奇数长度
            if (((e1 - s1 + 1) & 1) == 1) {
                if (A[mid1] > B[mid2]) {
                    // 手动验证
                    if (B[mid2] >= A[mid1 - 1]) {
                        return B[mid2];
                    }
                    e1 = mid1 - 1;
                    s2 = mid2 + 1;
                } else {
                    // 手动验证
                    if (A[mid1] >= B[mid2 - 1]) {
                        return A[mid1];
                    }
                    e2 = mid2 - 1;
                    s1 = mid1 + 1;
                }
            } else {
                // 偶数长度
                if (A[mid1] > B[mid2]) {
                    e1 = mid1;
                    s2 = mid2 + 1;
                } else {
                    e2 = mid2;
                    s1 = mid1 + 1;
                }
            }
        }
        return Math.min(A[s1], B[s2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }


}
