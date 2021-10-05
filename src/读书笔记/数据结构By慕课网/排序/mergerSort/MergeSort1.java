package 读书笔记.数据结构By慕课网.排序.mergerSort;

import java.util.Arrays;


public class MergeSort1 {
    private MergeSort1() {

    }

    public static void mergeSort(int[] arr) {
        // 临时数组一开始就创建,传递到merge将arr复制给temp数组
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        // 先递归,划分区域
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);
        // 再归并,mid>前一个数才归并
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int p = l, q = mid + 1;
        for (int i = l; i <= r; i++) {
            // 先判断两个指针越界的情况
            if (p > mid) {
                arr[i] = temp[q++];
            } else if (q > r) {
                arr[i] = temp[p++];
            } else if (temp[p] <= temp[q]) {// 一般情况,比较辅助中的值,放回arr中
                arr[i] = temp[p++];
            } else {
                arr[i] = temp[q++];
            }
        }
    }

    public static <E extends Comparable<E>> void mergerSort(E[] arr) {
        // 优化3：只生成一次辅助数组，并且merge中没有偏移量的操作了
        // Arrays.copyOf将源数组指定长度的元素复制成一个新数组
        E[] temp = Arrays.copyOf(arr, arr.length);
        mergerSort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void mergerSort(E[] arr, int l, int r, E[] temp) {
        // 优化2：指定长度内，可使用直接插入排序优化，但这种优化效果不明显，所以这里放弃使用
        if (l >= r) {
            return;
        }
        // 先递归分解
        int mid = l + (r - l) / 2;
        mergerSort(arr, l, mid, temp);
        mergerSort(arr, mid + 1, r, temp);
        // 优化1:arr[mid]>arr[mid]+1,再归并
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        // p,q遍历左右数组
        int p = l, q = mid + 1;
        // i遍历原数组
        for (int i = l; i <= r; i++) {
            if (p > mid) {
                arr[i] = temp[q++];
            } else if (q > r) {
                arr[i] = temp[p++];
            } else if (temp[p].compareTo(temp[q]) <= 0) {
                arr[i] = temp[p++];
            } else {
                arr[i] = temp[q++];
            }
        }
    }
}
