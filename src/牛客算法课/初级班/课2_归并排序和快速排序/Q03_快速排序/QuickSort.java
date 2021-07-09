package 牛客算法课.初级班.课2_归并排序和快速排序.Q03_快速排序;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 优化:随机和末尾元素交换
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] p = partition(arr, l, r);
        quickSort(arr, l, p[0] - 1);
        quickSort(arr, p[0] + 1, r);
    }

    // 荷兰国旗改进partition过程
    private static int[] partition(int[] arr, int l, int r) {
        // arr[r]是基准,对[l,r-1]进行划分
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 循环结束,more指向等于区域最后一个数=大于区域前一个数
        // 基准arr[r]与等于区域最后一个数做交换
        swap(arr, more, r);
        // 可以不要返回值,这里是方便后面的一道题,返回了小于,大于区域的起始位置
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
