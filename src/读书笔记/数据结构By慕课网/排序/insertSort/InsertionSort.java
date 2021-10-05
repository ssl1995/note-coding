package 读书笔记.数据结构By慕课网.排序.insertSort;


import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }

    // 默写版
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp < arr[j - 1]; j--) {
                // 前面的数比temp都大,每个数都依次往后移
                arr[j] = arr[j - 1];
            }
            // 空出的位置放temp
            arr[j] = temp;
        }
    }

    // 验证默写版or力扣912
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 插入排序1:背这个，性能较好，不使用交换
    public static <E extends Comparable<E>> void insertSort1(E[] data) {
        // 外层循环：遍历每个数组元素，i左边已经排好序，右边待排序
        for (int i = 0; i < data.length; i++) {
            // 取出当前遍历第一个元素，将它插入到前面已经排好序的数组中，合适的位置
            E temp = data[i];
            // 内层循环：遍历左边已经排好序的数组
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            // 内层发生移动，空出的j位置赋值给temp
            // 内层没有发生移动，temp原地赋值给自己
            data[j] = temp;
        }
    }

    // 插入排序2:使用交换，性能没有上面好
    public static <E extends Comparable<E>> void insertSort2(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static <E> void swap(E[] arr, int j, int i) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}


