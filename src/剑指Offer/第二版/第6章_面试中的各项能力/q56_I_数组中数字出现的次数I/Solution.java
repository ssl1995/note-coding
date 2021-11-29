package 剑指Offer.第二版.第6章_面试中的各项能力.q56_I_数组中数字出现的次数I;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int a = 0, b = 0;
        // 第一次遍历,a = 数1^数2
        for (int cur : nums) {
            a ^= cur;
        }
        // 找到a中第一个不相同的二进制位=数1和数2不相同的一个二进制位
        // 由于是十进制表示，所以rightOne 是2^n的表示形式
        int rightOne = a & (~a + 1);
        a = 0;// 重置a为0，便于下面^操作
        // 第二次遍历,利用不相同的二进制位,将原数组分为独立含数1和数2的两个部分
        for (int cur : nums) {
            if ((rightOne & cur) == 0) {// 这里只能用！=0或者==0来判断属于哪一个阵营
                b ^= cur;
            } else {
                a ^= cur;
            }
        }
        return new int[]{a, b};
    }

    // 先学习:一个数组中除一个数字外，其余数字出现了两次，找出这个数字
    public int oneNumbers(int[] nums) {
        // 0与任何数异或都为任何数本身
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
