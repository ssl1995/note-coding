package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第5章_优化时间和空间效率.q43_1到n中1出现的次数;

public class Solution {
    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     * 例如，输入12，1～12的十进制中包含1数字有1、10、11和12，一共出现了5次1。
     */
    public int countDigitOne(int n) {
        // 联想2304，2314，2324这三个数中low,cur,high,digit的关系
        // 初始化:low,cur,high,digit
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        // 第几位：个位、十位、百位等等，初始化为10^0=1
        int digit = 1;
        int res = 0;
        // high和cur同时为0，越过了最后一个高位，循环结束
        while (high != 0 || cur != 0) {
            // cur有三种情况:0,1,>1,自己用纸推出这三种表达式
            if (cur == 0) {
                // n=2304
                res += high * digit;
            } else if (cur == 1) {
                // n=2304
                res += high * digit + low + 1;
            } else if (cur > 1) {
                // n=2324
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
