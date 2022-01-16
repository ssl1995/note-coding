package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q51_数组中的逆序对.练习;

/**
 * @author SongShengLin
 * @date 2022/1/15 11:31 AM
 * @description
 */
public class Solution {

    private int res;

    public int reversePairs(int[] nums) {
        res = 0;
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, left, mid, right, temp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int p = left;
        int q = mid + 1;
        for (int i = left; i <= right; i++) {
            if (p > mid) {
                nums[i] = temp[q++];
            } else if (q > right) {
                nums[i] = temp[p++];
            } else if (temp[p] <= temp[q]) {
                nums[i] = temp[p++];
            } else {
                res += mid - p + 1;
                nums[i] = temp[q++];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 5, 6, 4};
        System.out.println(solution.reversePairs(nums));
    }
}
