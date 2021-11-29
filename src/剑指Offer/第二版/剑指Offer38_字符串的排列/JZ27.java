package 剑指Offer.第二版.剑指Offer38_字符串的排列;

import java.util.ArrayList;

public class JZ27 {

    private char[] cs;
    private ArrayList<String> res;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        cs = str.toCharArray();
        dfs(0);
        return res;
    }

    private void dfs(int pos) {
        if (pos == cs.length - 1) {
            res.add(new String(cs));
            return;
        }
        // 牛客题判断重复，导包只能用ArrayList，将就用
        ArrayList<Character> set = new ArrayList<>();
        for (int i = pos; i < cs.length; i++) {
            if (set.contains(cs[i])) {
                continue;
            }
            set.add(cs[i]);
            swap(cs, i, pos);
            dfs(pos + 1);
            swap(cs, i, pos);
        }
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }

}
