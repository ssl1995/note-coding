package 剑指Offer.C09_数学.剑指Offer64_求1加到n;

public class Solution {

    // 不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
    public int sumNums(int n) {
        // n>1时开始递归,不能用条件判断语句,就使用&&辅助完成判断
        // boolean x =...,A&&B整体需要一个返回值接受,否则单独返回会报错
        // A&&B,两边都需要布尔值,A的n>1比较容易想到,B中的>0利用1+...+n>0来凑布尔值
        boolean x = (n > 1) && (n += sumNums(n - 1)) > 0;
        // 返回n
        return n;
    }

    // 常见求和递归
    private int sumN(int n) {
        // 当n=1时停止递归
        if (n == 1) {
            return 1;
        }
        // n>1时,开始递归
        // sum=n+fun(n-1)=n+n-1+fun(n-2)...
        n += sumN(n - 1);
        return n;
    }
}
