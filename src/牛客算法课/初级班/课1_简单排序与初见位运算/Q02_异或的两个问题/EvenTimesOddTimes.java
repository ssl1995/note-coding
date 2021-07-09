package 牛客算法课.初级班.课1_简单排序与初见位运算.Q02_异或的两个问题;

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
        // a存第一次遍历的结果,b存第二次遍历的结果
        int a = 0, b = 0;
        // 第一次遍历,a = 数1^数2,由于两个数不相同,a!=0
        for (int cur : arr) {
            a ^= cur;
        }
        // 找到a中第一个不相同的二进制位=数1和数2不相同的一个二进制位
        int lastOne = a & (~a + 1);
        // 重置a=0,防止交换两个数异或重置为0的问题
        a = 0;
        // 第二次遍历,利用不相同的二进制位,将原数组分为独立含数1和数2的两个部分
        for (int cur : arr) {
            if ((lastOne & cur) == 1) {
                b ^= cur;
            } else {
                a ^= cur;
            }
        }
        System.out.println("num1:" + a);
        System.out.println("num2:" + b);
    }
}
