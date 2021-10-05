package 读书笔记.数据结构By慕课网.数组.字典序最小;

import java.util.Arrays;
import java.util.Comparator;

public class LowestString {

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s1 = "231";
        String s2 = "32";

        System.out.println(s1.compareTo(s2));// -1
        System.out.println(s2.compareTo(s1));// 1
    }
}
