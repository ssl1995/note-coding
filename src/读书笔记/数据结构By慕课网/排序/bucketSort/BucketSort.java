package 读书笔记.数据结构By慕课网.排序.bucketSort;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    // 桶排序1:桶记录每个元素出现的次数
    public static void bucketSort1(Integer[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 1.从所有数中找出最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 2.生成max+1个元素的桶,使得桶[0,max]
        int[] bucket = new int[max + 1];
        // 3.遍历数组，每个元素出现的个数加入桶
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        // 4.遍历桶，将非0数据放回原数组
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    /**
     * 桶排序2:用户指定每个桶的长度,另一种思维
     *
     * @param arr 待排序数组
     * @param c   每个桶的长度
     */
    public static void bucketSort2(int[] arr, int c) {
        if (c <= 0) {
            throw new IllegalArgumentException("c must be >0");
        }
        // 计算桶的数量
        int B = arr.length / c + (arr.length % c > 0 ? 1 : 0);
        List<Integer>[] buckets = new List[B];
        for (int i = 0; i < B; i++) {
            buckets[i] = new LinkedList<>();
        }
        // 找出数组中的最小值
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        // 元素如桶：在几号桶? = (arr[i]-min)/桶数c
        for (int num : arr) {
            buckets[(num - min) / c].add(num);
        }
        // 使用库函数对每个桶中元素进行排序
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
        }
        // 将桶中元素，放回原数组
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (Integer num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }
}
