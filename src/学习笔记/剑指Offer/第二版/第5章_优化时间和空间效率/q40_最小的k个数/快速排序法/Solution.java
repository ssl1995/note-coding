package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q40_最小的k个数.快速排序法;


import java.util.Arrays;

public class Solution {

    /**
     * 最小的k个数
     * 快速排序法:只用返回坐标k左边的数即可
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k < 0 || k > arr.length) {
            return new int[]{};
        }
        return quickSortK(arr, 0, arr.length - 1, k);
    }

    private int[] quickSortK(int[] arr, int L, int R, int k) {
        int i = L;
        int j = R;
        // while循环,将arr划分为[l,i]<arr[l],arr[l],arr[i+1,r]>arr[l]三个区域
        while (i < j) {
            // 注意：arr[L]作为基准，先移动j后移动i
            // 原因：arr[L]作为基准，必须先找到<区域的最后一个数位置，才能交换基准与该位置
            while (i < j && arr[j] >= arr[L]) {
                // 从后往前找到第一个arr[j]<arr[l]=从前往后找最后一个<区域的数
                j--;
            }
            while (i < j && arr[i] <= arr[L]) {
                i++;
            }
            swap(arr, i, j);
        }
        // 交换基准arr[l]和arr[i],保证划分区间
        swap(arr, i, L);
        // 若i>k ，说明小于k个数的边界在左边，移动右边界
        if (i > k) {
            quickSortK(arr, L, i - 1, k);
        } else if (i < k) {
            // i<k，移动左边界
            quickSortK(arr, i + 1, R, k);
        }
        // 若i==k,前k个数就是k下标前面的所有数,返回这个状态是无序的且修改了原数组arr
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            // 防止i = j = len，越过了len-1长度无法交换
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, 4)));
    }
}
