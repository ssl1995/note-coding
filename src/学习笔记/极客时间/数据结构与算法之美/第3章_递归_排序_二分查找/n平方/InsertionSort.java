package 学习笔记.极客时间.数据结构与算法之美.第3章_递归_排序_二分查找.n平方;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2021/12/30 8:55 AM
 * @description
 */
public class InsertionSort {

    public static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 插入排序：初试将数组分为已排序区间(第1个元素)、未排序区间(从第2个元素到末尾)
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                // <=就停止循环
                if (arr[j] <= temp) {
                    break;
                }
                // >就后移元素
                arr[j + 1] = arr[j];
            }
            // j+1下一个位置放temp
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        InsertionSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
