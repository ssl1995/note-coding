package 牛客算法课.基础班.课9_递归.Q02_字符串全排列和子序列;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    // LC38:字符串排列，返回全排列的字符串
    // s=abc，返回 [abc, acb, bac, bca, cab, cba]
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        char[] cs = s.toCharArray();
        process(cs, 0, list);
        list.sort(null);// 可以让list按照字典序排序一下更好看
        String[] res = new String[list.size()];// 加入结果集中
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void process(char[] cs, int i, List<String> res) {
        if (i == cs.length) {
            res.add(String.valueOf(cs));
        }
        boolean[] visit = new boolean[26];// visit[i]表示是否试过该字符，表示去重的判断
        for (int j = i; j < cs.length; j++) {
            if (!visit[cs[j] - 'a']) {
                visit[cs[j] - 'a'] = true;
                swap(cs, i, j);// 第一次遇见交换，递归加入结果集
                process(cs, i + 1, res);
                swap(cs, i, j);// 回溯，交换回原位置
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


}
