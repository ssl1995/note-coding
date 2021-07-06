package 剑指Offer.剑指Offer56_I_数组中数字出现的次数I;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int res1 = 0, res2 = 0;
        int m = 0, n = 1;
        // 1.遍历数组,让每个元素都^,出现两次的元素会抵消掉
        // 循环结束:m=res1^res2
        for (int num : nums) {
            m ^= num;
        }
        // 2.找出res1,res2不相同的第一位二进制数,以此来分组
        while ((m & n) == 0) {
            n <<= 1;
        }
        // 3.根据res1,res2不相同的第一位二进制数,将数组分为2组,分别执行^操作
        for (int num : nums) {
            // 4.每一组分别进行异或
            if ((num & n) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
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
