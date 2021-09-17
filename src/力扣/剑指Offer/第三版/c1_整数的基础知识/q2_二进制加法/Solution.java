package 力扣.剑指Offer.第三版.c1_整数的基础知识.q2_二进制加法;

/**
 * @author SongShengLin
 * @date 2021/9/8
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // 从最低位开始append，所以返回值最后需要反转才能返回
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
        // 最后要反转回去
        return sb.reverse().toString();
    }
}
