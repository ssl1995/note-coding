package 剑指Offer.第二版.剑指Offer67_字符串转换为整数;

public class Solution {

    public int strToInt(String str) {
        // 去掉首尾空格:原数组去首位空格后转换为字符数组
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int num = 0;
        // num越界的两种情况:int型最大值21474836472147483647,末尾数为7,/10后为boundary
        int maxBoundary = Integer.MAX_VALUE / 10;
        // sign:负号标记,1正号,-1负号
        int initIndex = 1, sign = 1;
        // 第一个部分有三种情况:+/-/数字
        if (c[0] == '-') {// -:遇到负号就sign成-1
            sign = -1;
        } else if (c[0] != '+') {// 剩下非数字,初始化指针=0
            initIndex = 0;
        }
        for (int i = initIndex; i < c.length; i++) {
            // 力扣：遇到非数字部分，可以忽略，直接当前得到的整数
            if (c[i] < '0' || c[i] > '9') {
                break;
            }
            // num越界的两种情况:int型最大值21474836472147483647,末尾数为7,/10后为boundary
            // 1.num=最大值/10 且 c[i]>'7',乘积后必越界
            // 2.num>最大值/10 乘积后必越界
            if (num > maxBoundary || num == maxBoundary && c[i] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 拼接数字部分
            num = num * 10 + (c[i] - '0');
        }
        // 返回符号*数字
        return sign * num;
    }

    public int myAtoi(String s) {
        char[] cs = s.trim().toCharArray();
        if (cs.length == 0) {
            return 0;
        }
        int num = 0;
        int maxBound = Integer.MAX_VALUE / 10;
        int sign = 1;
        int index = 1;
        if (cs[0] == '-') {
            sign = -1;
        } else if (cs[0] != '+') {
            index = 0;
        }
        for (int i = index; i < cs.length; i++) {
            if (cs[i] < '0' || cs[i] > '9') {
                break;
            }
            if (num > maxBound || (num == maxBound && cs[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (cs[i] - '0');
        }
        return sign * num;
    }
}
