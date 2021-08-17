package 剑指Offer.C01_数组.剑指Offer51_数组中的逆序对;

public class Solution {
    // 将res作为参数传递,会出现各种问题,直接定义成员变量省事
    private int res;

    // 归并排序法，原理是利用nums[i]>nums[j],那么[i,mid]中都是逆序对个数
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        res = 0;
        mergeSort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid, temp);
        mergeSort(nums, mid + 1, r, temp);
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
                // <=区域不会形成逆序对,所以和归并排序过程一样
                nums[i] = temp[p++];
            } else {
                // >说明必构成逆序对:[p,mid]与[mid+1,...]构成逆序对mid-p+1
                // 注意：力扣题不要求% 1000000007
                res += mid - p + 1;
                nums[i] = temp[q++];
            }
        }
    }

}
