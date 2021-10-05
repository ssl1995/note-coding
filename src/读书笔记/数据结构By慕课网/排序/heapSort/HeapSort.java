package 读书笔记.数据结构By慕课网.排序.heapSort;

import 读书笔记.数据结构By慕课网.排序.heapSort.堆.MaxHeap;

import java.util.Arrays;


public class HeapSort {
    private HeapSort() {

    }

    public static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        // 从小到大排序,是建立大根堆
        // 从大到小排序,是建立小根堆
        // 1.自底向上将原数组转换成最大堆，arr[0]是整个数组最大值
        buildMaxHeap(arr);
        // 2.依次交换数组首位（最大值）和数组末尾，然后对剩下的[0,n-1...)再进行堆化操作
        for (int j = arr.length - 1; j >= 0; j--) {
            // 交换大根堆顶部和数组末尾，数据末尾元素来到最终位置
            swap(arr, 0, j);
            // 依次对父节点为0位置,数组长度为i的元素进行堆化操作
            heapify(arr, 0, j);
        }
    }

    // 建立大根堆
    private static void buildMaxHeap(int[] arr) {
        for (int parent = (arr.length - 2) / 2; parent >= 0; parent--) {
            heapify(arr, parent, arr.length);
        }
    }

    // 对 arr[0, n) 所形成的最大堆中，索引为parent的父节点元素，进行heapify操作
    private static void heapify(int[] arr, int parent, int n) {
        while (2 * parent + 1 < n) {
            int left = 2 * parent + 1;
            if (left + 1 < n && arr[left] < arr[left + 1]) {
                left++;
            }
            // 大根堆,父最大,就停止遍历
            if (arr[left] <= arr[parent]) {
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
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 堆排序：原地堆排序
    public static <E extends Comparable<E>> void heapSort2(E[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 从小到大排序,是建立大根堆
        // 从大到小排序,是建立小根堆
        // 1.自底向上将原数组转换成最大堆，arr[0]是整个数组最大值
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            // i初始化=(n-2)/2,是原数组最后一个二叉树子树的父节点
            heapify(arr, i, arr.length);
        }
        // 2.依次交换数组首位（最大值）和数组末尾，然后对剩下的[0,n-1...)再进行堆化操作
        for (int i = arr.length - 1; i >= 0; i--) {
            // 交换大根堆顶部和数组末尾，数据末尾元素来到最终位置
            swap(arr, 0, i);
            // 依次对父节点为0位置,数组长度为i的元素进行堆化操作
            heapify(arr, 0, i);
        }
    }

    // 对 arr[0, n) 所形成的最大堆中，索引为parent的父节点元素，进行heapify操作
    private static <E extends Comparable<E>> void heapify(E[] arr, int parent, int n) {
        // 存在左孩子时候进行
        while (2 * parent + 1 < n) {
            int j = 2 * parent + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j++;
            }
            // 大根堆,父节点>=孩子最大值就停止
            if (arr[parent].compareTo(arr[j]) >= 0) {
                break;
            }
            swap(arr, parent, j);
            parent = j;
        }
    }


    // 堆排序1:使用自己的MaxHeap,看一遍即可
    public static <E extends Comparable<E>> void heapSort1(E[] data) {
        // 所有元素放进最大堆中，实现从大到小排序
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data) {
            maxHeap.add(e);
        }
        // 取出最大堆中元素，重新放进数组中，实现排序
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
