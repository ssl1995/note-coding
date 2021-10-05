package 读书笔记.数据结构By慕课网.排序.mergerSort;


import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r) {
        // 递归结束条件
        if (l >= r) {
            return;
        }
        // 分治
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 归并
        merge(arr, l, mid, r);
    }

    // 归并merger：已知两个有序的A和B数组，将A和B合并成有序数组
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        // 归并辅助函数，辅助数组从0开始的，原数组arr是从l开始
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        // i遍历原数组,i1,i2遍历辅助数组
        int p = l, q = mid + 1;
        for (int i = l; i <= r; i++) {
            // i>mid，左边部分遍历比较完毕
            if (p > mid) {
                // 注意temp数组是从0开始的，temp都需要-l才是原值
                arr[i] = temp[q++ - l];
            } else if (q > r) {
                arr[i] = temp[p++ - l];
            }// 单路归并左边<=v,右边>v
            else if (temp[p - l].compareTo(temp[q - l]) <= 0) {
                arr[i] = temp[p++ - l];
            } else {
                arr[i] = temp[q++ - l];
            }
        }
    }

    // merge1是比较好背的归并代码，但是多了一个复制回原数组的过程
    private static <E extends Comparable<E>> void merge1(E[] arr, int l, int mid, int r) {
        E[] temp = (E[]) new Object[r - l + 1];
        int i = 0;
        int p = l, q = mid + 1;
        while (p <= mid && q <= r) {
            temp[i++] = arr[p].compareTo(arr[q]) < 0 ? arr[p++] : arr[q++];
        }
        while (p <= mid) {
            temp[i++] = arr[p++];
        }
        while (q <= r) {
            temp[i++] = arr[q++];
        }
        // 最后记得复制回原数组
        for (int k = 0; k < temp.length; k++) {
            arr[l + k] = temp[k];
        }
    }

}
