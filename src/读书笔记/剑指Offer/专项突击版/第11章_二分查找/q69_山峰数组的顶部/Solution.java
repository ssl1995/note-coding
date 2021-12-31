package 读书笔记.剑指Offer.专项突击版.第11章_二分查找.q69_山峰数组的顶部;

/**
 * @author SongShengLin
 * @date 2021/10/24 10:13 上午
 * @description
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // arr规定至少有3个数，山峰值不可能是0和len-1位置，所以从1和len-2开始查找
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 山峰值均大于两边
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }
            // 山峰值两边均满足单调性，可以使用二分
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
