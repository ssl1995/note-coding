package 剑指Offer.剑指Offer20_表示数值的字符串;

public class Solution {

    public boolean isNumber(String s) {
        int n = s.length();
        int index = 0;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasSign = false;
        boolean hasDot = false;
        // 清除前面的空格
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        while (index < n) {
            // 1.先判断数字
            while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                hasNum = true;
                index++;
            }
            // 如果此时循环已到字符串末尾
            if (index == n) {
                break;
            }
            // 2.判断非数字部分
            if (s.charAt(index) == 'E' || s.charAt(index) == 'e') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                // E出现后,需要重新判断四个情况=重新置空
                hasNum = false;
                hasDot = false;
                hasSign = false;
            } else if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (s.charAt(index) == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (s.charAt(index) == ' ') {// 遇到中间的空格,循环结束,判断index长度
                break;
            } else {
                return false;
            }
            // 指针后移
            index++;
        }
        // 清除后面的空格
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        // 判断条件:有数字且index遍历到n
        return hasNum && index == n;
    }
}
