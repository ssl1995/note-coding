package tag刷题.C03_字符串.剑指Offer50_第一个只出现一次的字符;


public class Solution {

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
