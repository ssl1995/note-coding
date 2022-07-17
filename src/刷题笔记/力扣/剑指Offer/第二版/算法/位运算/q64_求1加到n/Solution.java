package 刷题笔记.力扣.剑指Offer.第二版.算法.位运算.q64_求1加到n;

public class Solution {

    /**
     * 求 `1+2+...+n` ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 言外之意：只能使用>、<、=、&、^、|、+、-这几个符号
     */
    public int sumNums(int n) {
        // n>1时开始递归,不能用条件判断语句,就使用&&辅助完成判断
        // boolean x =...,A&&B整体需要一个返回值接受,否则单独返回会报错
        // A&&B,两边都需要布尔值,A的n>1比较容易想到,B中的>0利用1+...+n>0来凑布尔值
        boolean x = (n > 1) && (n += sumNums(n - 1)) > 0;
        // 返回n
        return n;
    }

    /**
     * 常见求和递归
     */
    private int sumN(int n) {
        // 当n=1时停止递归
        // 不能用if，就用 n>1 &&
        if (n == 1) {
            return 1;
        }
        // n>1时,开始递归
        // sum=n+fun(n-1)=n+n-1+fun(n-2)...
        // 这个没有限制，可以使用，
        // 但是为了保证&&两边都是布尔,取n += sumN(n - 1)>0必成立
        n += sumN(n - 1);
        return n;
    }
}
