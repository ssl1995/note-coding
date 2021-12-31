package 读书笔记.剑指Offer.第二版.第6章_面试中的各项能力.q66_构建乘积数组;

public class Solution {

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
     * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
     * 不能使用除法
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[]{};
        }
        int len = a.length;
        // a[i]中每个元素左边所有数的乘积
        int[] left = new int[len];
        // a[i]中每个元素右边所有数的乘积
        int[] right = new int[len];
        int[] res = new int[len];
        // 初始化，两个dp数组左右两边的乘积为1
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
