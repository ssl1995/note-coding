package 牛客.算法课.基础班.课9_递归.Q02_字符串全排列和子序列;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsquences {


    // 打印一个字符串的全部子序列
    // str=abc，返回[abc, ab , a c, a  ,  bc,  b ,   c,    ]
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
        process(chs, i + 1, res);// 要当前整个位置组成的字符串加入res
        char tmp = chs[i];// 回溯1：当前位置置为'0'，为了回溯2需要记录tmp
        chs[i] = 0;
        process(chs, i + 1, res);// 不要当前这个字符，再次递归
        chs[i] = tmp;// 回溯2：当前位置归还为原位置的字符
    }

    public static void main(String[] args) {
        String test = "abc";
        List<String> res = printAllSubsquence(test);
        System.out.println(res);
    }

}
