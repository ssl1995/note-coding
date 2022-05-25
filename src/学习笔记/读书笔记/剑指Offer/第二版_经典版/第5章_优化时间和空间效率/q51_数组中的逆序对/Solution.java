package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第5章_优化时间和空间效率.q51_数组中的逆序对;

public class Solution {

    private int res;

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * 归并排序法，原理是利用nums[i]>nums[j],那么[i,mid]中都是逆序对个数
     */
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
                // 3,4,1,2
                // p到mid中间元素的个数，与q构成逆序对
                res += mid - p + 1;
                nums[i] = temp[q++];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 4, 1, 2};
        System.out.println(solution.reversePairs(arr));
    }

}
