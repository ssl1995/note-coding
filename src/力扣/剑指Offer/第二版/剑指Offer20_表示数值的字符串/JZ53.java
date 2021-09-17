package 力扣.剑指Offer.第二版.剑指Offer20_表示数值的字符串;

public class JZ53 {
    public boolean isNumeric(String str) {
        int n = str.length();
        int index = 0;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasSign = false;
        boolean hasDot = false;
        // 清除前面的空格
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }
        while (index < n) {
            // 1.先判断数字
            while (index < n && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                hasNum = true;
                index++;
            }
            // 如果此时循环已到字符串末尾
            if (index == n) {
                break;
            }
            // 2.判断非数字部分
            if (str.charAt(index) == 'E' || str.charAt(index) == 'e') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                // E出现后,需要重新判断三个情况=重新置空
                hasNum = false;
                hasDot = false;
                hasSign = false;
            } else if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (str.charAt(index) == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (str.charAt(index) == ' ') {// 遇到中间的空格,循环结束,判断index长度
                break;
            } else {
                return false;
            }
            // 指针后移
            index++;
        }
        // 清除后面的空格
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }
        // 判断条件:有数字且index遍历到n
        return hasNum && index == n;
    }
}
