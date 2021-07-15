package 剑指Offer.正序版.剑指Offer67_字符串转换为整数;

public class Solution {

    public int strToInt(String str) {
        // 去掉首尾空格:原数组去首位空格后转换为字符数组
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        // 初试res和最大值/10作为res每次乘积判断的边界boundary
        int num = 0, maxBoundary = Integer.MAX_VALUE / 10;
        // index:数字索引,初始化为1
        // sign:负号标记,1正号,-1负号
        int index = 1, sign = 1;
        // 第一个部分有三种情况:+/-/数字
        // +:初始化为1
        if (c[0] == '-') {// -:遇到负号就sign成-1
            sign = -1;
        } else if (c[0] != '+') {// 剩下非数字,初始化指针=0
            index = 0;
        }
        // index遍历字符串数组
        for (int i = index; i < c.length; i++) {
            // 遇到非数字部分,停止循环
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
}
