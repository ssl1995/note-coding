package 学习笔记.极客时间.数据结构与算法之美.第3章_递归_排序_二分查找.nlogn;

import java.util.Arrays;

public class MinHeapSort {

    /**
     * 小根堆
     */
    public static void heapSort(int[] arr) {
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

    /**
     * 堆化:范围[parent,n)，右边n是开区间取不到
     * 小根堆:将大数往上堆化
     */
    private static void heapify(int[] arr, int parent, int n) {
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
