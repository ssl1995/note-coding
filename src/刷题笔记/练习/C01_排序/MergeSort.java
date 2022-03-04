package 刷题笔记.练习.C01_排序;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/3/4 4:41 PM
 * @description
 */
public class MergeSort {


    private void sort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private void mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid, temp);
        mergeSort(nums, mid + 1, r, temp);
        merge(nums, l, mid, r, temp);
    }

    private void merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int p = l, q = mid + 1;
        for (int i = l; i <= r; i++) {
            if (p > mid) {
                nums[i] = temp[q++];
            } else if (q > r) {
                nums[i] = temp[p++];
            } else if (temp[p] <= temp[q]) {
                nums[i] = temp[p++];
            } else {
                nums[i] = temp[q++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {4, 5, 1, 6, 6};
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
