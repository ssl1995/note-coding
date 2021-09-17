package 牛客.算法课.基础班.课9_递归.Q05_数字转换为字符;

public class ConvertToLetterString {

    // Q:1-a,2-b,...,26-z,给一个数字字符串问它有多少种转换方式？
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    public static int process(char[] cs, int i) {
        if (i == cs.length) {// base case：i来到n位置，代表一次成功转换
            return 1;
        }
        if (cs[i] == '0') {// base case:i位置字符为0,代表无法转换
            return 0;
        }
        if (cs[i] == '1') {// ==‘1’说明后续可以有两种决策
            int res = process(cs, i + 1); // i自己作为一种决定，后续接着i+1后续有多少种决定
            if (i + 1 < cs.length) { // (i和i+1)作为单独的部分，后续有多少种方法
                res += process(cs, i + 2);
            }
            return res;
        }
        if (cs[i] == '2') {// ==‘2’说明后续可以有两种决策
            int res = process(cs, i + 1);  // i自己作为一种决定，后续接着i+1后续有多少种决定
            if (i + 1 < cs.length && (cs[i + 1] >= '0' && cs[i + 1] <= '6')) {// (i和i+1)作为单独的部分且后续为'0'到`6`(20-26嘛)，后续有多少种方法
                res += process(cs, i + 2);
            }
            return res;
        }
        return process(cs, i + 1);// ==‘3’-'9'，说明后续只能有一种决策
    }

    public static void main(String[] args) {
        System.out.println(number("11111"));
    }

}
