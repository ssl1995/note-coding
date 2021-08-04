package tag刷题.C09_数学.剑指Offer44_数字序列中的某一位数字;

public class Solution {

    public int findNthDigit(int n) {
        // 明确以下概念:数字num,数位digit,该数位下起始位置start，数位总数count
        // 条件给的序列：0123456789101112...,每一位记为数位
        // num:我们常见的数字10,11,12，称为数字num
        // digit:每个数字的所属的位数，比如数字10是一个两位数,记为digit=2
        // start:每位digit表示的位数起始值(即1,10,100),记为start
        // count：截止到返回值的数位总数，=9×start×digit,显然初始化为9

        long start = 1;
        int digit = 1;
        long count = 9;
        // 根据count = 9×start×digit,算出n所在的start和digit
        while (n > count) {// n<count时，代表n是该数位下的某个num
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;
        }
        // 上面while循环结束,n变为从该数位下的第一个数开始，此时n为[1,2,3...count]
        // 计算n属于该digit下的第几个num
        long num = start + (n - 1) / digit;
        // 计算n属于该digit下的第几个num
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
