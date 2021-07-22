package tag刷题.C09_位运算.剑指Offer56_I_数组中数字出现的次数I;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int a = 0, b = 0;
        // 第一次遍历,a = 数1^数2
        for (int num : nums) {
            a ^= num;
        }
        // 获取数1^数2最右边的二进制1
        int lastOne = a & (~a + 1);
        // a重置为0,防止数1与数2指向同一内存空间,异或重置为0的问题
        a = 0;
        // 第二次遍历,让lastOne来区分数1和数2,以次进行分组
        for (int num : nums) {
            if ((num & lastOne) == 0) {
                b ^= num;
            } else {
                a ^= num;
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
