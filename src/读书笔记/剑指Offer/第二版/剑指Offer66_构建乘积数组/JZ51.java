package 读书笔记.剑指Offer.第二版.剑指Offer66_构建乘积数组;


public class JZ51 {

    // 1个dp和1个res
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int len = A.length;
        int[] left = new int[len];// a[i]中每个元素左边所有数的乘积
        int[] res = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {// left从1到len
            left[i] = left[i - 1] * A[i - 1];
        }
        int right = 1;// 以1个变量维护a[i]右边乘积结果，初始化为1
        for (int i = len - 1; i >= 0; i--) {// 结果集从len-1到0构建
            res[i] = left[i] * right;// 每次都为当前数的左边乘积结果*它右边乘积结果
            right *= A[i];// 更新迭代arr[i]右边乘积结果
        }
        return res;
    }
}
