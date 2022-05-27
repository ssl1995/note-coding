package 刷题笔记.力扣.剑指Offer.第二版_经典版.第3章_高质量代码.q17_打印1到最大的n位数;

import java.util.Arrays;

public class Solution {

    /**
     * 打印从1到n位数的最大值，比如n=3，3位数最大值为999，则打印1，2，3到999
     * 方法：自己计算n位数，但是n很大时，n位数可能会越界；考虑用字符串表示大数
     */
    public int[] printNumbers(int n) {
        // n位数最大值：(int) Math.pow(10, n) - 1
        int[] res = new int[(int) Math.pow(10, n) - 1];
        // 遍历res的指针
        int index = 0;

        StringBuilder sb = new StringBuilder();
        // 初始化字符串的每一位都为"0"
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        while (!strInsertOneAndIsPassMax(sb)) {
            // 先删除字符串前面多余的0,找到非0的坐标
            int sbStart = 0;
            while (sbStart < sb.length() && sb.charAt(sbStart) == '0') {
                sbStart++;
            }
            // 非0元素赋值回原数组
            res[index++] = Integer.parseInt(sb.substring(sbStart));
        }
        return res;
    }

    /**
     * 将字符串表示的大数+1，并返回是否产生进位
     */
    private boolean strInsertOneAndIsPassMax(StringBuilder sb) {
        // 是否越过字符串表示大数的最大值
        boolean isPassMax = false;
        // 字符串的len-1位=对应大数的最低位，依次开始遍历
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = (char) (sb.charAt(i) + 1);
            if (ch > '9') {
                // 进位后已经超过9,就将原位置替换为0
                // replace：[start,end)取不到end位
                sb.replace(i, i + 1, "0");
                // 如果i到达0坐标，说明字符串表示的大数最高位发生了进位，返回true
                if (i == 0) {
                    isPassMax = true;
                }
            } else {
                sb.replace(i, i + 1, String.valueOf(ch));
                // 没有超过9的自增直接break返回
                break;
            }
        }
        return isPassMax;
    }

    public static void main(String[] args) {
//        StringBuilder str = new StringBuilder("001");
//        str.replace(0, 1, "2");
//        System.out.println(str);
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(2)));
    }
}
