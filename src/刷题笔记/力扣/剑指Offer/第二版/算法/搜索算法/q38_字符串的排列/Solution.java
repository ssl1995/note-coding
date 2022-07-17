package 刷题笔记.力扣.剑指Offer.第二版.算法.搜索算法.q38_字符串的排列;

import java.util.*;

public class Solution {

    private char[] cs;

    private List<String> res;

    /**
     * 求一个字符串所有字符的排列
     * 比如：s="aab"，返回["aba","aab","baa"]
     * 判断不加set，会返回["aab","aba","aab","aba","baa","baa"]
     */
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        res = new ArrayList<>();
        cs = s.toCharArray();
        dfs(0);
        // 结果列表转换为字符串数组list.toArray(目标数组构造器)
        return res.toArray(new String[0]);
    }

    /**
     * dfs：将cs中pos位置固定，然后开始递归后面数组组成排列
     */
    private void dfs(int pos) {
        // base case：固定位置来到最后一个字符
        if (pos == cs.length - 1) {
            res.add(String.valueOf(cs));
            return;
        }
        // 当字符串存在重复字符时，排列中也会出现重复排列
        // 为排除重复方案，固定某个字符时，保证每种字符只在此位置出现一次=剪枝
        Set<Character> set = new HashSet<>();
        // 从固定位置pos往后开始递归其他分支
        for (int i = pos; i < cs.length; i++) {
            // 先判断i位置上之前递归是否出现过
            if (set.contains(cs[i])) {
                continue;
            }
            set.add(cs[i]);
            // 交换,将cs[i]固定在pos位置
            swap(i, pos);
            // 递归固定后续index+1的位置
            dfs(pos + 1);
            // 回溯：交换回原数组顺序
            swap(i, pos);
        }
    }

    private void swap(int a, int b) {
        char temp = cs[a];
        cs[a] = cs[b];
        cs[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        System.out.println(Arrays.toString(solution.permutation(s)));
    }
}
