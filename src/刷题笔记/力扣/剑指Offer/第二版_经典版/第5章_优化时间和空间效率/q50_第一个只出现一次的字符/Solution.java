package 刷题笔记.力扣.剑指Offer.第二版_经典版.第5章_优化时间和空间效率.q50_第一个只出现一次的字符;


public class Solution {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
     */
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        // 小写字母只有26个
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
