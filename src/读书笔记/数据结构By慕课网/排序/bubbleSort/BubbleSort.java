package 读书笔记.数据结构By慕课网.排序.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    private BubbleSort() {
    }

    // 冒泡排序常规写法:从后往前比较，这种写法比较好记
    public static <E extends Comparable<E>> void bubbleSort0(E[] arr) {
        // 只需要n-1层外部循环
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
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

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    // 冒泡排序1:优化设置交换标志位
    public static <E extends Comparable<E>> void bubbleSort1(E[] arr) {
        // i是冒泡次数:n个数最多需要比较冒泡n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            // 优化：设置交换标志位
            boolean isSwap = false;
            // 内层实现相邻元素比较：每趟只比较j和j+1的元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
            // 内层没有发生交换，说明前面已经都排好序了，就不用再次比较
            if (!isSwap) {
                break;
            }
        }
    }

    // 冒泡排序2:优化设置最后交换位置，取消掉i++
    public static <E extends Comparable<E>> void bubbleSort2(E[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            int swapNextIndex = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    // 最后交换位置肯定是靠后的j+1
                    swapNextIndex = j + 1;
                }
            }
            i = arr.length - swapNextIndex;
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
