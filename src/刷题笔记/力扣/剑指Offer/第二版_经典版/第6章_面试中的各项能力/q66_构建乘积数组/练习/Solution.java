package 刷题笔记.力扣.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q66_构建乘积数组.练习;

/**
 * @author SongShengLin
 * @date 2022/1/17 11:28 PM
 * @description
 */
public class Solution {
    public int[] constructArr(int[] a) {
        if (a.length < 1) {
            return new int[]{};
        }
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
