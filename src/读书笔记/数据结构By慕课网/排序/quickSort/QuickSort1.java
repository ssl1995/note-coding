package 读书笔记.数据结构By慕课网.排序.quickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort1 {
    private QuickSort1() {
    }

    // 双路快速排序
    public static <E extends Comparable<E>> void quickSort2ways(E[] arr) {
        Random random = new Random();
        quickSort2ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort2ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition(arr, l, r, random);
        quickSort2ways(arr, l, p - 1, random);
        quickSort2ways(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        // [2,1,1,1,2,2,-1,5]
        //          i    j
        // i指向<=的区间的后一个元素，j指向>=区间的前一个元素
        // 初始化i指向l前一个位置，j指向数组末尾
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (i <= j && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            // i到达或者越过j循环跳出
            if (i >= j) {
                break;
            }
            // [2,1,1,1,2,2,-1,5]
            //          i    j 交换
            swap(arr, i, j);
            // 移动指针
            i++;
            j--;
        }
        // j始终指向<=基准最后一个数，将j和目标值l交换
        swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 1, 2, 0, 0};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 默写版
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

    //
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
}
