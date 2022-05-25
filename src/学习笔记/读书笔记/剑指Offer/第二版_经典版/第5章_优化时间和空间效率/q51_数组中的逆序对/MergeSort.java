package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第5章_优化时间和空间效率.q51_数组中的逆序对;

public class MergeSort {
    private MergeSort() {

    }

    /**
     * 学习完逆序对问题,学习归并排序
     */
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
            } else if (temp[p] <= temp[q]) {
                arr[i] = temp[p++];
            } else {
                arr[i] = temp[q++];
            }
        }
    }
}
