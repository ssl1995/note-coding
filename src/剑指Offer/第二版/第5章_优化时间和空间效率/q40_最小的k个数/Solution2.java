package 剑指Offer.第二版.第5章_优化时间和空间效率.q40_最小的k个数;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2021/12/22 10:49 PM
 * @description
 */
public class Solution2 {
    /**
     * 最小的k个数
     * 最小堆：手写堆排序
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 0 || k > arr.length) {
            return new int[]{};
        }
        // 手写堆排序，将arr进行从小到大排序
        heapSort(arr);
        // 复制前k个数返回
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    /**
     * 实现小根堆排序
     */
    private void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        // 小根堆，堆顶保持最大值
        for (int parent = (arr.length - 2) / 2; parent >= 0; parent--) {
            heapify(arr, parent, arr.length);
        }
        // 将堆顶最大值依次放回数组末尾
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }


    private void heapify(int[] arr, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            if (left + 1 < n && arr[left + 1] > arr[left]) {
                left++;
            }
            if (arr[parent] >= arr[left]) {
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
        Solution2 solution1 = new Solution2();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(solution1.getLeastNumbers(arr, 4)));
    }
}
