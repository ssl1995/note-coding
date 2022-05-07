package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q58_II_左旋转字符串.练习;

/**
 * @author SongShengLin
 * @date 2022/1/16 8:17 PM
 * @description
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcdefg";
        int n = 2;
        System.out.println(solution.reverseLeftWords(s, n));
    }
}
