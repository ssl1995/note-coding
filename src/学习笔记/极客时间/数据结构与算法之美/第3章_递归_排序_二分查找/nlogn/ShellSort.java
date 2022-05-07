package 学习笔记.极客时间.数据结构与算法之美.第3章_递归_排序_二分查找.nlogn;

import java.util.Arrays;

/**
 * @author SongShengLin
 * @date 2021/12/30 9:33 AM
 * @description
 */
public class ShellSort {

    /**
     * 希尔排序
     * 不稳定，时间复杂度为NlogN
     */
    public static void shellSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 步长step
        int step = arr.length / 2;
        // 插入排序最低就是步长为1
        while (step >= 1) {
            // 以step为距离进行插入排序
            for (int i = step; i < arr.length; i += step) {
                int temp = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (arr[j] <= temp) {
                        break;
                    }
                    arr[j + step] = arr[j];
                }
                arr[j + step] = temp;
            }
            // 步长缩小
            step /= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
        int[] arr1 = {4, 5, 6, 1, 3, 2};
        ShellSort.shellSort(arr);
        ShellSort.insertSort(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 插入排序
     * 稳定的、时间复杂度为N²
     */
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
}
