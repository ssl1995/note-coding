package 剑指Offer.第二版.剑指Offer40_最小的k个数;

import java.util.ArrayList;

public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k < 0 || k > input.length) {
            return new ArrayList<>();
        }
        return quickSortK(input, 0, input.length - 1, k);
    }

    private ArrayList<Integer> quickSortK(int[] arr, int L, int R, int k) {
        int i = L;
        int j = R;
        // while循环,将arr划分为[l,i]<arr[l],arr[l],arr[i+1,r]>arr[l]
        while (i < j) {
            // 注意：arr[L]作为基准，先移动j后移动i
            // 因为我只能和<区域最后一个交换才能保证左小右大，先移动j才能找到第一个<的数
            // 找到第一个arr[j]<arr[l]
            while (i < j && arr[j] >= arr[L]) {
                j--;
            }
            // 找到第一个arr[i]>arr[l]
            while (i < j && arr[i] <= arr[L]) {
                i++;
            }
            swap(arr, i, j);
        }
        // 交换基准arr[l]和arr[i],保证划分区间
        // 注意：swap里，防止i与L都约界，加上i==L就停止交换
        swap(arr, i, L);
        // 若i>k ，说明小于k个数的边界在左边，移动右边界
        if (i > k) {
            quickSortK(arr, L, i - 1, k);
        } else if (i < k) {// i<k，移动左边界
            quickSortK(arr, i + 1, R, k);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int m = 0; m < k; m++) {
            res.add(arr[m]);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {// 防止i = j = len，越过了len-1长度无法交换
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        JZ29 jz29 = new JZ29();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 8;
        jz29.GetLeastNumbers_Solution(arr, k);
    }

}
