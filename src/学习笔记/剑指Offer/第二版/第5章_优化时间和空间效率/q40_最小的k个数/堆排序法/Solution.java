package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q40_最小的k个数.堆排序法;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2022/1/12 11:19 AM
 * @description
 */
public class Solution {

    /**
     * 找出最小的k个数
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0 || k > arr.length) {
            return new int[]{};
        }
        int[] res = new int[k];
        // 找出最小值放到堆顶
        for (int parent = (arr.length - 2) / 2; parent >= 0; parent--) {
            heapify(arr, parent, arr.length);
        }
        int i = arr.length - 1;
        while (i > arr.length - 1 - k) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
            i--;
        }
        int index = 0;
        while (k > 0) {
            res[index] = arr[arr.length - 1 - index];
            index++;
            k--;
        }
        return res;
    }


    private void heapify(int[] arr, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            if (left + 1 < n && arr[left + 1] < arr[left]) {
                left++;
            }
            if (arr[parent] < arr[left]) {
                break;
            }
            swap(arr, parent, left);
            parent = left;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] res = solution.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }


}
