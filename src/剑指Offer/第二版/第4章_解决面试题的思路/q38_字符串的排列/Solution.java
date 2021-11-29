package 剑指Offer.第二版.第4章_解决面试题的思路.q38_字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    private char[] cs;

    private List<String> res;

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

    // dfs：将cs中pos位置固定，然后开始递归后面数组组成排列
    private void dfs(int pos) {
        // base case：固定位置来到最后一个字符
        if (pos == cs.length - 1) {
            res.add(String.valueOf(cs));
            return;
        }
        // 力扣可用各种API，牛客只能用ArrayList
        HashSet<Character> set = new HashSet<>();
        // 从固定位置pos往后开始递归其他分支
        for (int i = pos; i < cs.length; i++) {
            // 先判断i位置上之前递归是否出现过
            // ≠return，因为i+1...还要继续递归
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
