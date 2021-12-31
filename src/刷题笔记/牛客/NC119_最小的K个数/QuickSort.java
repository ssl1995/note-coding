package 刷题笔记.牛客.NC119_最小的K个数;

import java.util.Random;

/**
 * @author SongShengLin
 * @date 2021/12/30 11:30 PM
 * @description
 */
public class QuickSort {
    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        // random作为参数一致传递下去
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static void quickSort(int[] arr, int l, int r, Random random) {
        // 递归结束条件:显然只剩一个数时,递归结束
        if (l >= r) {
            return;
        }
        // 先划分区间
        int p = partition(arr, l, r, random);
        // 左边递归排序
        quickSort(arr, l, p - 1, random);
        // 右边递归排序
        quickSort(arr, p + 1, r, random);
    }

    /**
     * 原地分区函数
     */
    private static int partition(int[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        // p位置元数移动到l位置，让交换后的arr[l]作为基准，划分数组
        swap(arr, l, p);

        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }
            while (i <= j && arr[j] > arr[l]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        // 由于i++,j--操作，j指向<=arr[p]的最后一个位置，交换j和l位置元素
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
