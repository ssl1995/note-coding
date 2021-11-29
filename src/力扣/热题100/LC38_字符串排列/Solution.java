package 力扣.热题100.LC38_字符串排列;

import java.util.ArrayList;

public class Solution {
    public String[] permutation(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        char[] chs = s.toCharArray();
        process(chs, 0, list);
        list.sort(null);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // str[0...i-1]是之前作出的选择
    // str[i..]往后的字符，都可以在i位置上，请把所有形成的字符串形成的全排列，加入到res中去
    public void process(char[] str, int i, ArrayList<String> res) {
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
