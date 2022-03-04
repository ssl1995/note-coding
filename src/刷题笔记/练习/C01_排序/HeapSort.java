package 刷题笔记.练习.C01_排序;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/3/4 4:15 PM
 * @description
 */
public class HeapSort {


    /**
     * 写一个小根堆排序
     */
    private void heapSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int n = nums.length;
        for (int parent = (n - 2) / 2; parent >= 0; parent--) {
            heapify(nums, parent, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    private void heapify(int[] nums, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            if (left + 1 < n && nums[left] < nums[left + 1]) {
                left++;
            }
            if (parent >= left) {
                break;
            }
            swap(nums, parent, left);
            parent = left;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort solution = new HeapSort();
        int[] nums = {4, 5, 1, 6, 6};
        solution.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
