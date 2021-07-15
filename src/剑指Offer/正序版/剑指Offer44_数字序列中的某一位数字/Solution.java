package 剑指Offer.正序版.剑指Offer44_数字序列中的某一位数字;

public class Solution {

    public int findNthDigit(int n) {
        // 明确以下概念:数位n,数字num,数位digit,数位起始位置start
        // n:0123456789101112...,每一位记为数位
        // num:10,11,12称为我们常见的数字,11是10-19中的第2个数
        // digit:数字10是一个两位数,10的位数为2,记为digit
        // start:每位digit表示的位数起始值(即1,10,100),记为start

        // 初始化digit,位数从1开始
        int digit = 1;
        // 初始化start,从1开始
        long start = 1;
        // 每位digit下的数字数量:count=9×start×digit,显然初始化为9
        long count = 9;
        // 获取n属于的位数digit,以及该位数下的start
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            // 计算下一轮的count=9*start*digit
            count = (9 * start) * digit;
        }
        // 上面while循环结束,n变为从该数位下的第一个数开始
        // 计算n属于该digit下的第几个数
        long num = start + (n - 1) / digit;
        // 计算n是该digit下的第几个数的第几位
        int index = (n - 1) % digit;
        // 返回值规定为int,定位到char再-'0'即可
        return String.valueOf(num).charAt(index) - '0';
    }
}
