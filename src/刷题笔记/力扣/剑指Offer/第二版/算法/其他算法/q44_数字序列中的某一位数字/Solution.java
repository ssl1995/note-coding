package 刷题笔记.力扣.剑指Offer.第二版.算法.其他算法.q44_数字序列中的某一位数字;

public class Solution {

    /**
     * 数字序列中某一位的数字
     */
    public int findNthDigit(int n) {
        // 起始数字为1，数位为1，数位总量为9
        long start = 1;
        int digit = 1;
        long count = 9;
        // 根据count = 9×start×digit,算出n所在的start和digit
        // 1.确定n所在数字的位数digit和位数数量count
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;
        }
        // 2.确定n所在的数字，叫num
        long num = start + (n - 1) / digit;
        // 3.确定n所在的数字中的index
        int index = (n - 1) % digit;
        // 返回值规定为int,定位到char再-'0'即可
        return String.valueOf(num).charAt(index) - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 11;
        System.out.println(solution.findNthDigit(n));
    }
}
