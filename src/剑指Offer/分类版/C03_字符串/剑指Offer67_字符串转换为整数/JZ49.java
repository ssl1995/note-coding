package 剑指Offer.分类版.C03_字符串.剑指Offer67_字符串转换为整数;

public class JZ49 {
    public int StrToInt(String str) {
        char[] c = str.trim().toCharArray();// 去掉
        if (c.length == 0) {
            return 0;
        }
        int num = 0;
        // int型最大值21474836472147483647,末尾数为7,/10后为boundary
        int maxBoundary = Integer.MAX_VALUE / 10;
        int index = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            index = 0;
        }
        for (int i = index; i < c.length; i++) {
            // 牛客：遇到非数字部分，就返回0
            if (c[i] < '0' || c[i] > '9') {
                return 0;
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
