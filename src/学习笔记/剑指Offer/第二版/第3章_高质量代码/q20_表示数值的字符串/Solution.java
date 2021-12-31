package 学习笔记.剑指Offer.第二版.第3章_高质量代码.q20_表示数值的字符串;

public class Solution {

    public boolean isNumber(String s) {
        int n = s.length();
        int index = 0;
        //
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
            // 2.判断非数字部分:依次判断E、正负号、小数点、其他情况
            if (s.charAt(index) == 'E' || s.charAt(index) == 'e') {
                // 出现E，如果E已存在or前面没有整数，就返回false
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                // E出现后,需要重新判断四个情况=重新置空
                hasNum = false;
                hasDot = false;
                hasSign = false;
            } else if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                // 如果之前已经出现正负号、整数、小数点，就返回false
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (s.charAt(index) == '.') {
                // 如果之前已经出现过小数点、E，就返回false
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (s.charAt(index) == ' ') {
                // 中间出现空格,必错，跳出循环结束
                break;
            } else {
                // 其他情况直接返回false
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
