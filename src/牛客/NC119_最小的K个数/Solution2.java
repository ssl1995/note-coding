package 牛客.NC119_最小的K个数;

import java.util.ArrayList;

public class Solution2 {

    // Q：最小的k个数
    // 快排法：牛客和力扣使用快排法都没问题
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0) {
            return new ArrayList<>();
        }
        return quickSortK(input, k, 0, input.length - 1);
    }

    private ArrayList<Integer> quickSortK(int[] arr, int k, int l, int r) {
        int i = l;
        int j = r;
        while (i < j) {
            // 以arr[l]为基准，必须先走j，因为j先走一步的话，会先来到<arr[l]的最后一个数，此时交换i，j位置就不会出错
            // 如果以arr[r]为基准，必须先走i，因为i先走一步的话，会先来到>arr[l]的最后一个数，此时交换i，j位置就不会出错
            while (i < j && arr[j] >= arr[l]) {// 查找首个小于基准的数
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {// 查找首个大于基准的数
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) {
            quickSortK(arr, k, l, i - 1);
        } else if (i < k) {
            quickSortK(arr, k, i + 1, r);
        }
        // i==k，说明前面刚好有k个数，复制进res即可
        // NC119不能使用Arrays.copy()进行复制数组，那就参数传一个list接受前面的k个数
        ArrayList<Integer> res = new ArrayList<>();
        for (int m = 0; m < k; ++m) {
            res.add(arr[m]);
        }
        return res;
    }

    // 交换数组中两个元素的值
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
