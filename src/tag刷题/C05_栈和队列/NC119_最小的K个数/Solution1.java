package tag刷题.C05_栈和队列.NC119_最小的K个数;

import java.util.ArrayList;

public class Solution1 {

    // Q：最小的k个数
    // 注意：牛客这道题禁止使用jdk自带的PriorityQueue，牛客剑指offer40使用本题解法会提示超时，无法理解
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        quickSort(input, res, k, 0, input.length - 1);
        return res;
    }

    private void quickSort(int[] arr, ArrayList<Integer> res, int k, int l, int r) {
        int i = l;
        int j = r;
        while (l < r) {
            while (l < r && arr[r] >= arr[i]) {
                r--;
            }
            while (l < r && arr[l] <= arr[i]) {
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, i, l);
        if (l > k) {
            quickSort(arr, res, k, i, l - 1);
        } else if (l < k) {
            quickSort(arr, res, k, l + 1, j);
        } else {
            //取前面的k个即可
            for (int m = 0; m < k; ++m) {
                res.add(arr[m]);
            }
        }

    }

    //交换数组中两个元素的值
    private void swap(int[] arr, int i, int j) {
        // 防止下标越界
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
