package 牛客算法课.基础班.课3_堆排序和桶排序.Q01_堆排序;

import java.util.Arrays;

public class MinHeapSort {

    // 波波老师版本小根堆
    public static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        // 建立小根堆，先将数组最大值放在父节点(数组首位)上
        maxUp(arr);
        // 每次交换末尾元素和数组首位，让最大值下沉
        for (int i = arr.length - 1; i >= 0; i--) {
            // 交换大根堆顶部和数组末尾，数据末尾元素来到最终位置
            swap(arr, 0, i);
            // 依次对父节点为0位置,数组长度为i的元素进行堆化操作
            maxDown(arr, 0, i);
        }
    }

    // 从数组末尾开始建立大根堆
    private static void maxUp(int[] arr) {
        for (int parent = (arr.length - 2) / 2; parent >= 0; parent--) {
            maxDown(arr, parent, arr.length);
        }
    }

    // 对arr[0, n)所形成的最大堆中，索引为parent的父节点元素，进行heapify操作
    private static void maxDown(int[] arr, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            if (left + 1 < n && arr[left] < arr[left + 1]) {
                left++;
            }
            // 大根堆,父最大,就停止遍历
            if (arr[parent] >= arr[left]) {
                break;
            }
            // 否则就最大值交换到父节点
            swap(arr, parent, left);
            // 父节点循环进行下去
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
