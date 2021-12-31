package 读书笔记.牛客算法课.基础班.课8_前缀树和贪心算法.Q02_贪心算法;

import java.util.Arrays;

public class Q1_LowestLexicography {

    // Q:将字符串数组拼接成一个字符串,使得字符串的字典序最小
    // 补充题：去看力扣386 字典序排序
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 每两个字符串按照以下策略拼接:(a, b) -> ((a + b).compareTo(b + a)),整体就成字典序最小
        Arrays.sort(strs, (a, b) -> ((a + b).compareTo(b + a)));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"b", "a", "d", "c"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestString(strs2));

    }
}
