package 刷题笔记.力扣.剑指Offer.第二版.算法.模拟.q67_字符串转换为整数.练习;

/**
 * @author SongShengLin
 * @date 2022/1/17 11:43 PM
 * @description
 */
public class Solution {
    public int myAtoi(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }
        char[] cs = s.trim().toCharArray();
        int index = 0, sign = 1;
        if (cs[0] == '-') {
            index = 1;
            sign = -1;
        } else if (cs[0] == '+') {
            index = 1;
        }
        int num = 0;
        int boundary = Integer.MAX_VALUE / 10;
        for (int i = index; i < cs.length; i++) {
            if (cs[i] < '0' || cs[i] > '9') {
                break;
            }
            if (num > boundary || (num == boundary && cs[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (cs[i] - '0');
        }
        return sign * num;
    }
}
