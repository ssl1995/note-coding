package 学习笔记.读书笔记.剑指Offer.第二版_经典版.第6章_面试中的各项能力.q58_I_反转单词顺序.练习;

/**
 * @author SongShengLin
 * @date 2022/1/16 8:06 PM
 * @description
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int last = s.length() - 1;
        int index = last;
        while (index >= 0) {
            while (index >= 0 && s.charAt(index) != ' ') {
                index--;
            }
            sb.append(s, index + 1, last + 1).append(" ");

            while (index >= 0 && s.charAt(index) == ' ') {
                index--;
            }

            last = index;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "hello world";
        System.out.println(solution.reverseWords(s));
    }
}
