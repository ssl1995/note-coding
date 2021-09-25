package 慕课网数据结构.排序.quickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
    private QuickSort2() {
    }

    // 三路快排:波波老师写法
    public static <E extends Comparable<E>> void quickSort3ways(E[] arr) {
        Random random = new Random();
        quickSort3ways(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort3ways(E[] arr, int l, int r, Random random) {
        if (l >= r) return;

        // 分治:因为三路快排中间不用递归,避免partition返回值麻烦,所以partition和quickSort3ways写在一起

        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        // 核心：arr[l+1,lt]<v ; arr[lt+1,i-1]=v ; arr[gt,r]>v
        // lt指向<的最后一个元素，i指针遍历，gt指向>的第一个元素
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
                // i所在位置从后往前发生了交换,导致nums[i]变新，需要重新比较,i无需++
            } else {
                // arr[i]==arr[l]
                i++;
            }
        }
        // 交换l位置和小于最后一个数
        swap(arr, l, lt);

        // 三路快排抛弃掉中间的部分，不再递归
        quickSort3ways(arr, l, lt - 1, random);
        quickSort3ways(arr, gt, r, random);
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1};
        quickSort3way(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 默写版
    public static void quickSort3way(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        Random random = new Random();
        quickSort3way(arr, 0, arr.length - 1, random);
    }

    private static void quickSort3way(int[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        // 分治:因为三路快排中间不用递归,避免partition返回值麻烦,所以partition和quickSort3ways写在一起

        int randomIndex = l + random.nextInt(r - l + 1);
        swap(arr, l, randomIndex);
        // 核心：arr[l+1,less]<v ; arr[lt+1,i-1]=v ; arr[more,r]>v
        // lt指向<的最后一个元素，i指针遍历，gt指向>的第一个元素
        int less = l, i = l + 1, more = r + 1;
        while (i < more) {
            if (arr[i] < arr[l]) {
                less++;
                swap(arr, i, less);
                i++;
            } else if (arr[i] > arr[l]) {
                more--;
                swap(arr, i, more);
                // i所在位置从后往前发生了交换,导致nums[i]变新，需要重新比较,i无需++
            } else {
                i++;
            }
        }
        // 交换l位置和小于最后一个数
        swap(arr, l, less);

        // 三路快排抛弃掉中间的部分，不再递归
        quickSort3way(arr, l, less - 1, random);
        quickSort3way(arr, more, r, random);

    }


    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}


