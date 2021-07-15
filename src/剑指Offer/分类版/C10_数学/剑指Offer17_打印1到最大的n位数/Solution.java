package 剑指Offer.分类版.C10_数学.剑指Offer17_打印1到最大的n位数;

public class Solution {
    // 方法1：自己算边界值
    public int[] printNumbers1(int n) {
        // 计算出最大边界
        int boundary = 1;
        for (int i = 1; i <= n; i++) {
            // 每次乘以10
            boundary *= 10;
        }
        // 定义一个返回值结果
        int[] res = new int[boundary - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    // 方法2:使用库函数计算边界值
    public int[] printNumbers2(int n) {
        // 10^n-1是n位数最大值 = 数组长度
        int[] res = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < res.length; i++) {
            // 数组元素比索引大1,因为数是从1开始的
            res[i] = i + 1;
        }
        return res;
    }

    // 方法3:字符串自增,返回给int
    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        StringBuilder sb = new StringBuilder();
        // sb中往后添加n个0
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        int resIndex = 0;
        // 没有发生进位就将字符串的值放回数组
        while (!addOne(sb)) {
            // 先删除字符串前面多余的0,找到非0的坐标
            int sbIndex = 0;
            while (sbIndex < sb.length() && sb.charAt(sbIndex) == '0') {
                sbIndex++;
            }
            // 非0元素赋值回原数组
            res[resIndex] = Integer.parseInt(sb.substring(sbIndex));
            resIndex++;
        }
        return res;
    }

    // 字符串+1,返回值是判断是否产生进位
    private boolean addOne(StringBuilder sb) {
        // 是否超过最大值
        boolean passMax = false;
        // 从字符串最高位开始往前遍历
        for (int index = sb.length() - 1; index >= 0; index--) {
            char addOneChar = (char) (sb.charAt(index) + 1);
            if (addOneChar > '9') {
                // 进位后已经超过9,就将原位置替换为0
                sb.replace(index, index + 1, "0");
                if (index == 0) {
                    passMax = true;
                }
            } else {
                sb.replace(index, index + 1, String.valueOf(addOneChar));
                // 没有超过9的自增直接break返回
                break;
            }
        }
        return passMax;
    }

    public static void main(String[] args) {
//        StringBuilder str = new StringBuilder("001");
//        str.replace(0, 1, "2");
//        System.out.println(str.toString());
        Solution solution = new Solution();
        solution.printNumbers(1);
    }
}
