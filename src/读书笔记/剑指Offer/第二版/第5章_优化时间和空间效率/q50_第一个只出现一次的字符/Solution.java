package 读书笔记.剑指Offer.第二版.第5章_优化时间和空间效率.q50_第一个只出现一次的字符;


public class Solution {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
     */
    public char firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return ' ';
        }
        // 尽量不使用特殊的数据结构，用数组存次数比较快
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
