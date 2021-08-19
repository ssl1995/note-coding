package 剑指Offer.分类版.C09_数学.剑指Offer65_不用加减乘除做加法;

public class JZ48 {
    public int Add(int num1, int num2) {
        int sum = num1;
        while (num2 != 0) {
            sum = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }
}
