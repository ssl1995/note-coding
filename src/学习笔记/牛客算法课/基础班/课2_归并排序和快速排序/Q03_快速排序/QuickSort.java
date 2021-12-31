package 学习笔记.牛客算法课.基础班.课2_归并排序和快速排序.Q03_快速排序;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    // 默写版
    public static void quickSort(int[] arr) {
        // random作为参数一致传递下去
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static void quickSort(int[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r, random);
        quickSort(arr, l, p - 1, random);
        quickSort(arr, p + 1, r, random);
    }


    private static int partition(int[] arr, int l, int r, Random random) {
        int randomIndex = l + random.nextInt(r - l + 1);
        swap(arr, l, randomIndex);
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
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
