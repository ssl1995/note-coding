package 慕课网数据结构.排序.quickSort;

import 慕课网数据结构.排序.helpUtils.ArrayGenerator;

import java.util.Arrays;

public class QuickSort3 {
    private QuickSort3() {
    }

    // 使用荷兰国旗问题写法，写三路快排
    public static <E extends Comparable<E>> void quickSortByZ(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSortByZ(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void quickSortByZ(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 实现随机：交换数组开头和末尾
        swap(arr, (l + (int) (Math.random() * (r - l + 1))), r);
        int[] p = partition(arr, l, r);
        quickSortByZ(arr, l, p[0] - 1);
        quickSortByZ(arr, p[1] + 1, r);
    }

    private static <E extends Comparable<E>> int[] partition(E[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l].compareTo(arr[r]) < 0) {
                swap(arr, ++less, l++);
            } else if (arr[l].compareTo(arr[r]) > 0) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 数组末尾不参与比较，最后交换more和r
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        System.out.println("No Sorted:" + Arrays.toString(arr1));
        quickSortByZ(arr1);
        System.out.println("Is Sorted:" + Arrays.toString(arr1));
    }

}
