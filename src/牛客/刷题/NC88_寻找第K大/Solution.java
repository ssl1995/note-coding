package 牛客.刷题.NC88_寻找第K大;

import java.util.Arrays;

public class Solution {

    /**
     * 查找数组中第k大的数
     */
    public int findKth(int[] a, int n, int K) {
        if (a == null || a.length == 0 || a.length < K) {
            return -1;
        }
        return quickSortK(a, n, K, 0, n - 1);
    }

    private int quickSortK(int[] arr, int n, int k, int l, int r) {
        int i = l;
        int j = r;
        while (i < j) {
            // 这里以arr[l]为基准，必须先走j，因为j先走一步的话，会先来到<arr[l]的最后一个数，此时交换i，j位置就不会出错
            // 如果以arr[r]为基准，必须先走i，因为i先走一步的话，会先来到>arr[l]的最后一个数，此时交换i，j位置就不会出错
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 快排使得数组从小到大排序
        // 第1大的数 = 第n-1洗标的数
        // 第k大的数 = 第n-k下标的数
        if (i == n - k) {
            return arr[i];
        } else if (i < n - k) {// <,左边界前进
            return quickSortK(arr, n, k, i + 1, r);
        } else {// >,右边界后退
            return quickSortK(arr, n, k, l, i - 1);
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 10, 9, 9, 8, 7, 5, 6, 4, 3, 4, 2};
        int n = arr.length;
        int k = 3;
        int res = solution.findKth(arr, n, k);
        System.out.println(res);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
