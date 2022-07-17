package 刷题笔记.力扣.剑指Offer.第二版.算法.位运算.q56_I_数组中数字出现的次数I;

import java.util.Arrays;

public class Solution {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 要求时间复杂度是O(n)，空间复杂度是O(1)。
     */
    public int[] singleNumbers(int[] nums) {
        int a = 0, b = 0;
        //  0与任何数异或都为任何数本身
        // 第一次遍历，a存那两个数字异或的结果，因为两数不相同，a≠0
        for (int num : nums) {
            a ^= num;
        }
        // 找到a中最右边的1，二次遍历划分数组
        int rightOne = a & (~a + 1);
        // 重置a为0，便于下面^操作
        a = 0;
        // 第二次遍历,利用不相同的二进制位,将原数组分为独立含数1和数2的两个部分
        for (int num : nums) {
            // 这里只能用!=0或者==0来判断属于哪一个阵营
            // 因为二进制0和十进制0都是通用，000...0==0
            if ((rightOne & num) == 0) {
                b ^= num;
            } else {
                a ^= num;
            }
        }
        return new int[]{a, b};
    }

    /**
     * 先学习:一个数组中除一个数字外，其余数字出现了两次，找出这个数字
     */
    public int oneNumbers(int[] nums) {
        // 异或两大特性：
        //   0与任何数异或都为任何数本身
        //   任何一个数异或它自己都为0
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 5, 2};
        System.out.println(Arrays.toString(solution.singleNumbers(arr)));
    }
}
