package 慕课网数据结构.排序.quickSort;


import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private QuickSort() {
    }

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        // random作为参数一致传递下去
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random) {
        // 递归结束条件:显然只剩一个数时,递归结束
        if (l >= r) return;
        // 先划分区间
        int p = partition(arr, l, r, random);
        // 对左边递归排序
        quickSort(arr, l, p - 1, random);
        // 对右边递归排序
        quickSort(arr, p + 1, r, random);
    }

    // 将 arr 从 l 到 r 这一区间的值分成两个区域，左边区域的每个数都比基数小，右边区域的每个数都比基数大
    // 返回中间值的下标
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // 比较基准:永远是arr[l]
        // 解决有序数组问题:交换l和随机索引p
        int randomIndex = l + random.nextInt(r - l + 1);
        swap(arr, l, randomIndex);

        // j初始化为左边界
        int j = l;
        // 从左边界第一个数开始遍历
        for (int i = l + 1; i <= r; i++) {
            // j此时要求是指向<区域最后一个数
            if (arr[i].compareTo(arr[l]) < 0) {
                // 发现<arr[l],先移动j+1使得j指向>=arr[j]的第一个数,然后交换[i,j]位置的数
                j++;
                swap(arr, i, j);
            }
        }
        // 此时j指向<区域最后一个数,交换[l,j]位置的数
        swap(arr, l, j);
        // 交换后,j指向>=区域第一个数
        return j;
    }

    public static void main(String[] args) {
//        Integer[] arr = {2, 1, -1, 1, 2, 5};
        int[] arr = {2, 1, -1, 1, 2, 5};
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

    private static int partition(int[] arr, int l, int r, Random random) {
        int randomIndex = l + random.nextInt(r - l + 1);
        swap(arr, l, randomIndex);
        // j初始化为左边界
        int j = l;
        // 从左边界第一个数开始遍历
        for (int i = l + 1; i <= r; i++) {
            // j此时要求是指向<区域最后一个数
            if (arr[i] < arr[l]) {
                // 发现<arr[l],先移动j+1使得j指向>=arr[j]的第一个数,然后交换[i,j]位置的数
                swap(arr, i, ++j);
            }
        }
        // 由于循环跳出j指向<区域最后一个数,与基准arr[l]交换
        swap(arr, l, j);
        // 交换后,j指向>=第一个数,返回该数=下标值
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
