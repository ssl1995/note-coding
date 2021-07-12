package 牛客算法课.基础班.课9_递归.Q02_字符串排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPermutations {

    public static List<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        res.sort(null);
        return res;
    }

    // str[0...i-1]是之前作出的选择
    // str[i..]往后的字符，都可以在i位置上，请把所有形成的字符串形成的全排列，加入到res中去
    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }
        // visit[i]表示是否试过该字符，表示去重的判断
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String test = "abc";
        // 打印全排列(不重复）
        List<String> res = Permutation(test);
        System.out.println(res);// [abc, acb, bac, bca, cab, cba]
        // 打印子序列
        PrintAllSubsquences printAllSubsquences = new PrintAllSubsquences();
        List<String> res1 = printAllSubsquences.printAllSubsquence(test);
        System.out.println(res1);// [abc, ab , a c, a  ,  bc,  b ,   c,    ]
    }


}
