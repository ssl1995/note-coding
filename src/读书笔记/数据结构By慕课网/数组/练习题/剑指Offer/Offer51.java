package 读书笔记.数据结构By慕课网.数组.练习题.剑指Offer;

/**
 * 数组的逆序对
 */
public class Offer51 {
    private int res;

    // 暴力解法：两个for循环,缺点是超时
    public int reversePairs1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    // 归并排序法，原理是利用nums[i]>nums[j],那么[i,mid]中都是逆序对个数
    public int reversePairs2(int[] nums) {
        int[] temp = new int[nums.length];
        res = 0;
        sort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void sort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        // >保证了，如果j位置小于i位置的，左边未排序中的肯定是逆序对
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r, temp);
        }
    }

    private void merge(int[] arr, int l, int mid, int r, int[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > r) {
                arr[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i++];
            } else {
                // 判断逆序对条件：temp[i]>temp[j]
                res += mid - i + 1;
                arr[k] = temp[j++];
            }
        }
    }
}
