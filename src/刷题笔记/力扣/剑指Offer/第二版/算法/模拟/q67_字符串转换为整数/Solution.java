package 刷题笔记.力扣.剑指Offer.第二版.算法.模拟.q67_字符串转换为整数;

public class Solution {
    /**
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用库函数。
     * 边界：""字符串、非法输入、正负号、整型溢出问题 -> 最后才 num=num*10+字符数字
     */
    public int strToInt(String str) {
        // 去掉首尾空格:原数组去首位空格后转换为字符数组
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int num = 0;
        // num越界的两种情况:int型最大值21474836472147483647,
        // 由于最后num=num*10+字符数,所以边界需要/10
        int maxBoundary = Integer.MAX_VALUE / 10;
        // sign:正负号标记,1正号,-1负号
        int index = 0, sign = 1;
        // 第一个部分有三种情况:+/-/数字
        if (c[0] == '-') {
            sign = -1;
            index = 1;
        } else if (c[0] == '+') {
            index = 1;
        }
        for (int i = index; i < c.length; i++) {
            // 力扣：遇到非数字部分，可以忽略，直接当前得到的整数
            if (c[i] < '0' || c[i] > '9') {
                break;
            }
            // 1.num=最大值/10 且 c[i]>'7',乘积后必越界
            // 2.num>最大值/10 乘积后必越界
            if (num > maxBoundary || (num == maxBoundary && c[i] > '7')) {
                // 越界后，返回整型最值
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 不越界，才拼接数字部分
            num = num * 10 + (c[i] - '0');
        }
        // 返回符号*数字
        return sign * num;
    }

    public static void main(String[] args) {
        // ""字符串trim()后，长度为0
        System.out.println("".trim().length());
    }
}
