package 学习笔记.剑指Offer.第二版.第3章_高质量代码.q20_表示数值的字符串;

public class Solution {

    /**
     * 判断一个字符串是否是整数
     */
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }

        s = s.trim();
        int n = s.length();
        int index = 0;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasSign = false;
        boolean hasDot = false;

        while (index < n) {
            // 越过数字
            while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                hasNum = true;
                index++;
            }
            // 不包含特殊符号，只含数字，返回true
            if (index == n) {
                return true;
            }
            // 判断特殊符号：正负号、E、小数点
            char ch = s.charAt(index);
            if (ch == '+' || ch == '-') {
                if (hasSign || hasDot || hasNum) {
                    return false;
                }
                hasSign = true;
            } else if (ch == 'E' || ch == 'e') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                hasSign = false;
                hasDot = false;
                hasNum = false;
            } else if (ch == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else {
                // 其他情况直接返回失败
                return false;
            }
            index++;
        }
        return hasNum && index == n;
    }
}
