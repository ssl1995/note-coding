package tag刷题.C09_数学.剑指Offer43_1到n中1出现的次数;

public class Solution {
    public int countDigitOne(int n) {
        // 初始化:low,cur,high,digit
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        int digit = 1;// 10^0=1
        int res = 0;
        while (high != 0 || cur != 0) {
            // cur有三种情况:0,1,>1,自己用纸推出这三种表达式
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else if (cur > 1) {
                res += (high + 1) * digit;
            }
            // 更新low,cur,high,digit
            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }
        return res;
    }
}
