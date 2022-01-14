package 学习笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q50_第一个只出现一次的字符.练习;

/**
 * @author SongShengLin
 * @date 2022/1/14 9:27 AM
 * @description
 */
public class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abaccdeff";
        System.out.println(solution.firstUniqChar(s));
    }
}
