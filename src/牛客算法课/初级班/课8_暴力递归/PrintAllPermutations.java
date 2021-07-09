package 牛客算法课.初级班.课8_暴力递归;

import java.util.ArrayList;

public class PrintAllPermutations {

    public static ArrayList<String> Permutation(String str) {
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

}
