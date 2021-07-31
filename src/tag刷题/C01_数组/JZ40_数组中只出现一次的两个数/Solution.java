package tag刷题.C01_数组.JZ40_数组中只出现一次的两个数;

import java.util.Arrays;

public class Solution {
    public int[] FindNumsAppearOnce(int[] array) {
        int a = 0, b = 0;
        // 第一次遍历,a = 数1^数2
        for (int cur : array) {
            a ^= cur;
        }
        // 找到a中第一个不相同的二进制位=数1和数2不相同的一个二进制位
        // 由于是十进制表示，所以rightOne 是2^n的表示形式
        int rightOne = a & (~a + 1);
        a = 0;// 重置a为0，便于下面^操作
        // 第二次遍历,利用不相同的二进制位,将原数组分为独立含数1和数2的两个部分
        for (int cur : array) {
            if ((rightOne & cur) == 0) {// 这里只能用！=0或者==0来判断是需要哪一个阵营
                b ^= cur;
            } else {
                a ^= cur;
            }
        }
        int num1 = Math.min(a, b);
        int num2 = Math.max(a, b);
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 1, 6};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.FindNumsAppearOnce(arr1)));
    }
}
