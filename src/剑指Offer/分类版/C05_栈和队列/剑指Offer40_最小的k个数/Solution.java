package 剑指Offer.分类版.C05_栈和队列.剑指Offer40_最小的k个数;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    // 法1:优先级队列
    public int[] getLeastNumbers1(int[] arr, int k) {
        // 求最小的k个数,创建大根堆是最简单的思维
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        // 数组前面k个数,加入大根堆
        for (int i = 0; i < k; i++) {
            maxQueue.add(arr[i]);
        }
        // [k,len-1],遇到小于大根堆堆顶的,大根堆就移除堆顶,添加该元素
        for (int i = k; i < arr.length; i++) {
            if (!maxQueue.isEmpty() && maxQueue.peek() > arr[i]) {
                maxQueue.remove();
                maxQueue.add(arr[i]);
            }
        }
        // 将大根堆元素放入结果数组中
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = maxQueue.remove();
        }
        return res;
    }

    // 法2:快速排序法
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return findKth(arr, 0, arr.length - 1, k);
    }

    private int[] findKth(int[] arr, int l, int r, int k) {
        int i = l;
        int j = r;
        // while循环,将arr划分为[l,i]<arr[l],arr[l],arr[i+1,r]>arr[l]
        while (i < j) {
            // 找到第一个arr[j]<arr[l]
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            // 找到第一个arr[i]>arr[l]
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        // 交换基准arr[l]和arr[i],保证划分区间
        swap(arr, i, l);
        // 若i>k ，说明小于k个数的边界在左边
        if (i > k) {
            return findKth(arr, l, i - 1, k);
        }
        if (i < k) {
            return findKth(arr, i + 1, r, k);
        }
        // 若i==k,前k个数就是k下标前面的所有数
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
