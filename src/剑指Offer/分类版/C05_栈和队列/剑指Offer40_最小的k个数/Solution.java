package 剑指Offer.分类版.C05_栈和队列.剑指Offer40_最小的k个数;


import java.util.Arrays;

public class Solution {

    // 快速排序法:只用返回坐标k左边的数即可
    // 注意：与NC119相比，力扣剑指Offer40使用我的那个堆排序解法会超时
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSortK(arr, 0, arr.length - 1, k);
    }

    private int[] quickSortK(int[] arr, int l, int r, int k) {
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
            return quickSortK(arr, l, i - 1, k);
        } else if (i < k) {
            return quickSortK(arr, i + 1, r, k);
        } else {
            // 若i==k,前k个数就是k下标前面的所有数
            return Arrays.copyOf(arr, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
