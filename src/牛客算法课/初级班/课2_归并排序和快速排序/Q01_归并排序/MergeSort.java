package 牛客算法课.初级班.课2_归并排序和快速排序.Q01_归并排序;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 类似后序遍历=后续先获取坐标信息,再merge操作
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // help[0,r-l+1]拷贝回arr[l,r]
        System.arraycopy(help, 0, arr, l, r - l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
