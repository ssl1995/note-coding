package 读书笔记.剑指Offer.第二版.剑指Offer66_构建乘积数组;

public class Solution {

    // 2个dp和1个res
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[]{};
        }
        int len = a.length;
        int[] left = new int[len];// a[i]中每个元素左边所有数的乘积
        int[] right = new int[len];// a[i]中每个元素右边所有数的乘积
        int[] res = new int[len];
        // 初始化，两个dp数组左右两边的乘积为1
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {// left从1到len
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {// right从len-2到0计算
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < len; i++) {// 构建结果集
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
