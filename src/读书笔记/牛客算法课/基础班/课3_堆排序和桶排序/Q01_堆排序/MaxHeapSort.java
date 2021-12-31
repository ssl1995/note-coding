package 读书笔记.牛客算法课.基础班.课3_堆排序和桶排序.Q01_堆排序;

import java.util.Arrays;

public class MaxHeapSort {

    // 大根堆
    public static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        // 从最右子树开始建立大根堆，堆顶保持最小值
        for (int parent = (arr.length - 2) / 2; parent >= 0; parent--) {
            heapify(arr, parent, arr.length);
        }
        // 大根堆依次将堆顶元素放回数组末尾
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    // 大根堆，堆化操作
    private static void heapify(int[] arr, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            if (left + 1 < n && arr[left + 1] < arr[left]) {
                left++;
            }
            if (arr[parent] <= arr[left]) {
                break;
            }
            swap(arr, parent, left);
            parent = left;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
