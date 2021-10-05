package 读书笔记.剑指Offer.第二版.剑指Offer65_不用加减乘除做加法;

public class Solution {


    // a+b = 两数无进位和+进位值
    public int add(int a, int b) {
        // 如果b=0，直接返回a,所以sum初始化为a
        int sum = a;
        while (b != 0) {// 进位信息为0才停止
            sum = a ^ b;// a+b不能用+，那就sum用^先算无进位相加的结果
            b = (a & b) << 1;// b每次获取成当前两数的进位值结果
            a = sum; // a迭代作为下轮的sum
        }
        return sum;
    }

    public static void main(String[] args) {
        int a=1;
        int b=3;
        Solution solution = new Solution();
        System.out.println(solution.add(a, b));
    }

}
