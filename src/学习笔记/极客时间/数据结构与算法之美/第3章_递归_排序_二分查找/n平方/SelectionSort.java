package 学习笔记.极客时间.数据结构与算法之美.第3章_递归_排序_二分查找.n平方;

/**
 * @author SongShengLin
 * @date 2021/12/30 9:22 AM
 * @description
 */
public class SelectionSort {

    private static void selectSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 初始化：已排序区间(无)，未排序区间(0到n-1)
        for (int i = 0; i < arr.length - 1; i++) {
            // 选择排序是在未排序区间中找最小值下标
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 交换，这里的交换打破了稳定性
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
