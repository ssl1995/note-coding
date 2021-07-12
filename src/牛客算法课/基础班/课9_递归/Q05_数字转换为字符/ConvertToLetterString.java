package 牛客算法课.基础班.课9_递归.Q05_数字转换为字符;

public class ConvertToLetterString {

    // Q:1-a,2-b,...,26-z,给一个字符串问它有多少种转换方式
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    // i之前的位置，如何转换已经决定了
    // i...之后有多少种转换的结果
    public static int process(char[] str, int i) {
        // 之前到末尾就是一种转换结果
        if (i == str.length) {
            return 1;
        }
        // ==‘0’说明后面不能再转换了
        if (str[i] == '0') {
            return 0;
        }
        // ==‘1’说明后续可以有两种决策
        if (str[i] == '1') {
            // i自己作为一种决定，后续接着i+1后续有多少种决定
            int res = process(str, i + 1);
            // (i和i+1)作为单独的部分，后续有多少种方法
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        // ==‘2’说明后续可以有两种决策
        if (str[i] == '2') {
            // i自己作为一种决定，后续接着i+1后续有多少种决定
            int res = process(str, i + 1);
            // (i和i+1)作为单独的部分且后续为'0'到`6`(20-26嘛)，后续有多少种方法
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        // ==‘3’-'9'，说明后续只能有一种决策
        return process(str, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(number("11111"));
        System.out.println(number("26"));
    }

}
