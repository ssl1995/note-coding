package 学习笔记.读书笔记.剑指Offer.第三版_专项突击版.第1章_整数的基础知识.q2_二进制加法;

/**
 * @author SongShengLin
 * @date 2021/9/8
 */
public class Solution {
    // 二进制加法：a=11,b=10,res=101
    public String addBinary(String a, String b) {
        // sb从最低位开始append，所以返回值最后需要反转才能返回
        StringBuilder sb = new StringBuilder();
        // 模仿十进制加法，从末尾开始计算
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            sb.append(sum);
        }
        if (carry == 1) {// 最高位是否产生进位
            sb.append(1);
        }
        // sb从最低位开始append，所以返回值最后需要反转才能返回
        return sb.reverse().toString();
    }
}
