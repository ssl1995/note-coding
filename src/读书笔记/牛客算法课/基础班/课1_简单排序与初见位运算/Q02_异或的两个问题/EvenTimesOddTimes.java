package 读书笔记.牛客算法课.基础班.课1_简单排序与初见位运算.Q02_异或的两个问题;

public class EvenTimesOddTimes {

    // Q1:一个数为奇数次，其他数为偶数次
    public static int question1(int[] arr) {
        int res = 0;
        for (int cur : arr) {
            res ^= cur;
        }
        return res;
    }

    // Q2:两个数为奇数次，其他数为偶数次
    public static void question2(int[] arr) {
        int a = 0, b = 0;
        // 第一次遍历,a = 数1^数2
        for (int cur : arr) {
            a ^= cur;
        }
        // 找到a中第一个不相同的二进制位=数1和数2不相同的一个二进制位
        // 由于是十进制表示，所以rightOne 是2^n的表示形式
        int rightOne = a & (~a + 1);
        a = 0;// 重置a为0，便于下面^操作
        // 第二次遍历,利用不相同的二进制位,将原数组分为独立含数1和数2的两个部分
        for (int cur : arr) {
            if ((rightOne & cur) == 0) {// 这里只能用！=0或者==0来判断是需要哪一个阵营
                b ^= cur;
            } else {
                a ^= cur;
            }
        }
        System.out.println("num1:" + a);
        System.out.println("num2:" + b);
    }
}
