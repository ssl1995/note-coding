package 牛客算法课.基础班.课9_递归.Q02_字符串排列;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsquences {


    // 打印一个字符串的全部子序列
    public static List<String> printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        List<String> res = new ArrayList<>();
        process(chs, 0, res);
        return res;
    }

    public static void process(char[] chs, int i, List<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
            return;
        }
        process(chs, i + 1, res);// 要当前字符
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1, res);// 不要当前字符
        chs[i] = tmp;
    }

    public static void main(String[] args) {
        String test = "abc";
//        char[] cs = test.toCharArray();
//        System.out.println(cs.length);
//        cs[2] = 0;
//        System.out.println(cs.length);
        List<String> res = printAllSubsquence(test);
        System.out.println(res);
    }

}
