package 剑指Offer.剑指Offer38_字符串的排列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private char[] cs;

    private List<String> res = new LinkedList<>();

    public String[] permutation(String s) {
        cs = s.toCharArray();
        dfs(0);
        // 结果列表转换为字符串数组list.toArray(目标数组构造器)
        return res.toArray(new String[0]);
    }

    private void dfs(int index) {
        // 递归结束:遍历到cs数组末尾,加入结果集,递归结束
        if (index == cs.length - 1) {
            res.add(String.valueOf(cs));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        // 从index后面元素开始遍历交换
        for (int i = index; i < cs.length; i++) {
            // 该论递归出现重复字符,就剪纸跳出当前循环
            if (set.contains(cs[i])) {
                continue;
            }
            // 该论递归无出现重复元素,加入set,给下轮递归使用
            set.add(cs[i]);
            // 交换,将cs[i]固定在第index位
            swap(i, index);
            // 递归固定后续index+1的位置
            dfs(index + 1);
            // 交换回数组顺序
            swap(i, index);
        }
    }

    private void swap(int a, int b) {
        char temp = cs[a];
        cs[a] = cs[b];
        cs[b] = temp;
    }
}
