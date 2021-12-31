package 读书笔记.数据结构与算法之美.第3章_递归_排序_二分查找.n平方;

/**
 * @author SongShengLin
 * @date 2021/12/30 8:48 AM
 * @description
 */
public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // i是冒泡次数:n个数最多需要比较冒泡n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwap = false;
            // 从前往后冒泡比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 交换相邻的两个元素，大数往后冒泡
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
