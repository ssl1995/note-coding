package interview.美团;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Q1 {
    // 第一题
    public static int q1(int[] arr, int n, int k) {
        int count = 0;
        int res = 0;
        for (int num = 0; num < n; num++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < num) {
                    count++;
                }
                if (count == k) {
                    res = num;
                    break;
                }
            }
        }
        return res;
    }

    public static String q2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ' ') {
                temp.add(cs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(temp.get(0));
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) != temp.get(i - 1)) {
                sb.append(temp.get(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a iC C   C GmyyyySp p";
        System.out.println(q2(s));// aiCGmySp测试成功
    }
}
