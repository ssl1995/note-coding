package 力扣.剑指Offer.第三版.第3章_字符串.q20_回文子字符串的个数;

public class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            // 回文中心往外扩
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
