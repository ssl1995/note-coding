package 读书笔记.牛客算法课.基础班.课2_归并排序和快速排序.Q01_归并排序;

import java.util.Arrays;

public class ReversePairs {
    // 定义结果返回值
    private int res;

    // 逆序对:前面一个数字大于后面的数字,构成一对逆序对
    // 归并排序法，原理是利用nums[i]>nums[j],那么[i,mid]中都是逆序对个数
    public int reversePairs(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        res = 0;
        sort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void sort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid, temp);
        sort(nums, mid + 1, r, temp);
        // 关键1：>保证了，如果j位置小于i位置的，左边未排序中的肯定是逆序对
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r, temp);
        }
    }

    private void merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int p = l, q = mid + 1;
        for (int i = l; i <= r; i++) {
            if (p > mid) {
                nums[i] = temp[q++];
            } else if (q > r) {
                nums[i] = temp[p++];
            } else if (temp[p] <= temp[q]) {
                nums[i] = temp[p++];
            } else {
                // 关键2：关键1保证了左边>右边,mid到p距离就是逆序对
                res += mid - p + 1;
                nums[i] = temp[q++];
            }
        }
    }

}
