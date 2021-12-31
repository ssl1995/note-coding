package 学习笔记.牛客算法课.基础班.课3_堆排序和桶排序.Q02_计数排序;

import java.util.Arrays;

public class CountSort {

    // 计数排序：假设原数组中最大值不超过200
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 1.找出原数组中最大值
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        // 2.桶长度为最大值+1，保证index=max成立
        int[] bucket = new int[max + 1];
        // 3.原数组中每个元素的值作为桶的下标，桶中值为出现的次数
        for (int num : arr) {
            bucket[num]++;
        }
        // 4.原数组中依次添加桶的索引，直到桶值减少为0结束
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
